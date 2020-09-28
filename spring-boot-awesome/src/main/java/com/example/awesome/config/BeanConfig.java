package com.example.awesome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @ClassName ：BeanConfig
 * @Description ：TODO
 * @Author ：lkv587
 * @Date ：2020-01-13 11:08
 * @Version ：V1.0.0
 */
@Configuration
public class BeanConfig {

    /**
     * 文件上传
     * 去除默认standerMultipartResolver MultipartAutoConfiguration.class
     */
//    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(50 * 1024 * 1024);
        resolver.setMaxUploadSize(50 * 1024 * 1024);//上传文件大小 50M 50*1024*1024
        return resolver;
    }
    /**
     * RestTemplate
     */



}
