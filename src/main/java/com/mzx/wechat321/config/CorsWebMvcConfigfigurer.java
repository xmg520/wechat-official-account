package com.mzx.wechat321.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsWebMvcConfigfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                .allowedOrigins("*")// 1 允许任何域名使用
                .allowedHeaders("*")// 2 允许任何头
                .allowedMethods("*");// 3 允许任何方法（post、get等）
    }
}
