package com.github.rbaul.spring.boot.sample.client.feign.extension.clients.api2.config;

import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignSampleClientApiWithFallbackConfig {

    @Bean
    public ErrorDecoder errorDecoder(){
        return new ErrorDecoder.Default();
    }

    @Bean
    public Encoder encoder(){
        return new Encoder.Default();
    }
}