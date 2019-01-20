package com.github.rbaul.spring.boot.feign.extension.pagesupport;

import com.fasterxml.jackson.databind.Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageableJacksonConfiguration {

    @Bean
    public Module pageableJacksonModule() {
        return new PageableJacksonModule();
    }
}
