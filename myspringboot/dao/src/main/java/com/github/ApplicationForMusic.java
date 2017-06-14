package com.github;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by qwe on 2017/3/20.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.github.mapper")
public class ApplicationForMusic {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationForMusic.class);
    }

}
