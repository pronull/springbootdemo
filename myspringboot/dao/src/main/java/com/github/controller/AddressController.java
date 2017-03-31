package com.github.controller;

import com.github.entity.Address;
import com.github.entity.User;
import com.github.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qwe on 2017/3/28.
 */
@RestController
public class AddressController {


    @Autowired
    private AddressService addressService;

    @RequestMapping("/test")
    @ResponseBody
    public String putCache(){
        addressService.findUser(1l,"wang","yunfei");
        //addressService.findAddress(1l,"anhui","hefei");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return "ok";
    }
    @RequestMapping("/test2")
    @ResponseBody
    public String testCache(){
        User user = addressService.findUser(1l,"wang","yunfei");
        Address address =addressService.findAddress(1l,"anhui","hefei");
        System.out.println("我这里没执行查询");
        System.out.println("user:"+"/"+user.getName()+"/"+user.getAge());
        System.out.println("address:"+"/"+address.getProvince()+"/"+address.getCity());
        return "ok";
    }

}
