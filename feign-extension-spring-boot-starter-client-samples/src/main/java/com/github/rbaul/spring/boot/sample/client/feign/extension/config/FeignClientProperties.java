package com.github.rbaul.spring.boot.sample.client.feign.extension.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "sample.client.api")
public class FeignClientProperties {
    /**
     * API location of application service.
     */
    private String path = "http://localhost:8080";

}
