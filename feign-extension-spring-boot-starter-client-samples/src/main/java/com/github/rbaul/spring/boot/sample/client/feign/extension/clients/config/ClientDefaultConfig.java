package com.github.rbaul.spring.boot.sample.client.feign.extension.clients.config;

import com.github.rbaul.spring.boot.feign.extension.pagesupport.PageableQueryEncoder;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

public class ClientDefaultConfig {

    @Bean
    public PageableQueryEncoder extendedEncoder(ObjectFactory<HttpMessageConverters> messageConverters){
        return new PageableQueryEncoder(new SpringEncoder(messageConverters));
    }

    @Bean
    public ErrorDecoder errorDecoder(){
        return new ClientErrorDecoder();
    }

}
