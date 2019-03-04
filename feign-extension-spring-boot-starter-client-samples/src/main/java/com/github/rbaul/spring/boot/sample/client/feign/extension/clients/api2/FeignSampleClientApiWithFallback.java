package com.github.rbaul.spring.boot.sample.client.feign.extension.clients.api2;

import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.api2.config.FeignSampleClientApiWithFallbackConfig;
import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.SampleDto;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "feign-example-client-fallback",
        path = "/",
//		fallbackFactory = VnfPackageStoreClient.VnfPackageStoreClientFallbackFactory.class,
//		primary = false,
//		decode404 = true,
//        url = "${example.client.api.path}"
        url = "http://localhost:8080",
        fallback = FeignSampleClientApiWithFallback.FeignSampleClientApiFallback.class,
//        fallbackFactory = FeignSampleClientApiFallbackFactory.class
        configuration = FeignSampleClientApiWithFallbackConfig.class
)
public interface FeignSampleClientApiWithFallback {
    @PostMapping("info")
    String getInfo(@RequestBody SampleDto sampleDto);

    @GetMapping("proxy")
    String getInfoFromProxy(@RequestBody SampleDto sampleDto);

    @Slf4j
    @Component
    static class FeignSampleClientApiFallback implements FeignSampleClientApiWithFallback {
        @Override
        public String getInfo(SampleDto sampleDto) {
            log.debug("fallback called");
            return "fallback called";
        }

        @Override
        public String getInfoFromProxy(SampleDto sampleDto) {
            log.debug("fallback called");
            return null;
        }
    }

}
