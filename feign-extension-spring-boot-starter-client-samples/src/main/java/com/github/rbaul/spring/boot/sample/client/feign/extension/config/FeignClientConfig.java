package com.github.rbaul.spring.boot.sample.client.feign.extension.config;

import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.api1.FeignSampleClientApi;
import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.api2.FeignSampleClientApiWithFallback;
import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.api3.FeignSampleClientApiWithFallbackFactory;
import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.config.ClientDefaultConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FeignClientProperties.class)
@EnableFeignClients(
//        defaultConfiguration = ClientDefaultConfig.class, // Not working with implicit config per api
        basePackageClasses = {FeignSampleClientApi.class, FeignSampleClientApiWithFallback.class, FeignSampleClientApiWithFallbackFactory.class})
//@EnableFeignClients(clients = {FeignExampleClientApi.class, FeignExampleClientApi2.class,
//        FeignExampleClientApiWithFallback.class, FeignExampleClientApiWithFallbackFactory.class},
//        defaultConfiguration = ClientDefaultConfig.class)
public class FeignClientConfig {

}
