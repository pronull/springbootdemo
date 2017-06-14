package com.github.controller;

import com.github.vo.resp.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 17/6/12.
 */
@Api(description = "mapper刷新服务接口")
@RestController
@RequestMapping("/v2/pc/warehouse/mapper/refresh")
@CrossOrigin({"*"})
public class MybatisRefresher {

    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public MybatisRefresher(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
        try {
            this.doScanMapperXml();
            this.doRefreshFileMapping();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Logger log = Logger.getLogger(this.getClass());
    private Resource[] mapperLocations;
    private String packageSearchPath = "classpath*:com/ecworking/warehouse/mapper/*.xml";
    private Configuration configuration;
    private HashMap<String, Long> fileMapping = new HashMap<>();// 记录文件是否变化


    @ApiOperation("刷新所有mapper")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Resp<String> doRefreshAll() {
        String msg = "文件未更改";
        try {
            this.configuration = sqlSessionFactory.getConfiguration();
            // 重新加载
            this.doScanMapperXml();
            if (this.isChanged()) {
                //重新刷新fileMapping
                this.doRefreshFileMapping();
                // 清理
                this.doRemoveConfig(configuration);
                // 重新加载
                for (Resource configLocation : mapperLocations) {
                    try {
                        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configLocation.getInputStream(),
                                configuration, configLocation.toString(), configuration.getSqlFragments());
                        xmlMapperBuilder.parse();
                        msg = "刷新成功";
                        log.info("mapper文件[" + configLocation.getFilename() + "]加载成功");
                    } catch (IOException e) {
                        log.error("mapper文件[" + configLocation.getFilename() + "]不存在或内容格式不对");
                        continue;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
        }
        return Resp.success(msg);
    }

    private void doRefreshFileMapping() throws IOException {
        fileMapping.clear();
        for (Resource mapperLocation : mapperLocations) {
            fileMapping.put(mapperLocation.getFilename(),mapperLocation.contentLength() + mapperLocation.lastModified());
        }
    }
    /**
     * 扫描xml文件所在的路径      * @throws IOException
     */
    private void doScanMapperXml() throws IOException {
        this.mapperLocations = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
        for (int i = 0; i < this.mapperLocations.length; i++) {
            Resource a = new FileSystemResource( this.mapperLocations[i].getURL().getPath().replace("target/classes","src/main/resources"));
            this.mapperLocations[i] = a;
        }
    }

    private void doClearMap(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
        Field field = classConfig.getDeclaredField(fieldName);
        field.setAccessible(true);
        Map mapConfig = (Map) field.get(configuration);
        mapConfig.clear();
    }
    /**
     * 清空Configuration中几个重要的缓存      * @param configuration      * @throws Exception
     */
    private void doRemoveConfig(Configuration configuration) throws Exception {
        Class<?> classConfig = configuration.getClass();
        doClearMap(classConfig, configuration, "mappedStatements");
        doClearMap(classConfig, configuration, "caches");
        doClearMap(classConfig, configuration, "resultMaps");
        doClearMap(classConfig, configuration, "parameterMaps");
        doClearMap(classConfig, configuration, "keyGenerators");
        doClearMap(classConfig, configuration, "sqlFragments");
        doClearSet(classConfig, configuration, "loadedResources");
    }

    boolean isChanged() throws IOException {
        boolean flag = false;
        for (Resource resource : mapperLocations) {
            String resourceName = resource.getFilename();
            boolean addFlag = !fileMapping.isEmpty() && !fileMapping.containsKey(resourceName);// 此为新增标识
            // 修改文件:判断文件内容是否有变化
            Long compareFrame = fileMapping.get(resourceName);
            long lastFrame = resource.contentLength() + resource.lastModified();
            boolean modifyFlag = null != compareFrame && compareFrame.longValue() != lastFrame;// 此为修改标识
            // 新增或是修改时,存储文件
            if (addFlag || modifyFlag) {
                flag = true;
            }
        }
        return flag;
    }

    @SuppressWarnings("rawtypes")
    private void doClearSet(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
        Field field = classConfig.getDeclaredField(fieldName);
        field.setAccessible(true);
        Set setConfig = (Set) field.get(configuration);
        setConfig.clear();
    }

}
