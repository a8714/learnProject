package com.atguigu.vod.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author roo
 * @date 2023/3/12
 */
@SpringBootApplication
@MapperScan("com.atguigu.vod.service.mapper")
public class ServiceVodApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
