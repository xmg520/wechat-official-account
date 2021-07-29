package com.mzx.wechat321;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.mzx.wechat321.dao")
@SpringBootApplication
public class Wechat321Application {

    public static void main(String[] args) {
        SpringApplication.run(Wechat321Application.class, args);
    }

}
