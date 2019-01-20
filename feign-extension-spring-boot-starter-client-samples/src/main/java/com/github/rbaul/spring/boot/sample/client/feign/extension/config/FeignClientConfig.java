package com.github.rbaul.spring.boot.sample.client.feign.extension.config;

import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.FeignSampleClientApi;
import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.config.ClientConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FeignClientProperties.class)
@EnableFeignClients(basePackageClasses = FeignSampleClientApi.class, defaultConfiguration = ClientConfig.class)
//@EnableFeignClients(clients = {FeignExampleClientApi.class, FeignExampleClientApi2.class,
//        FeignExampleClientApiWithFallback.class, FeignExampleClientApiWithFallbackFactory.class},
//        defaultConfiguration = ClientConfig.class)
public class FeignClientConfig {

}
