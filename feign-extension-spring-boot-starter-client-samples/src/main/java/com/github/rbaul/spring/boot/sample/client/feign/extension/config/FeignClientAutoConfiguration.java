package com.github.rbaul.spring.boot.sample.client.feign.extension.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableConfigurationProperties(FeignClientProperties.class)
public class FeignClientAutoConfiguration {

    @Configuration
    @ComponentScan(basePackages = "com.github.rbaul.spring.boot.sample.client.feign.extension")
    public static class FeignApiConfiguration {

    }
}
