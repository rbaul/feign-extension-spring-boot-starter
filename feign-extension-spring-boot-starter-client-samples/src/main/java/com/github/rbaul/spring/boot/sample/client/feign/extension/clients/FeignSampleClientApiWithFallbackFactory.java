package com.github.rbaul.spring.boot.sample.client.feign.extension.clients;

import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.SampleDto;
import feign.codec.ErrorDecoder;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "feign-example-client-fallback-factory",
        path = "/",
//		fallbackFactory = VnfPackageStoreClient.VnfPackageStoreClientFallbackFactory.class,
//		primary = false,
//		decode404 = true,
//        url = "${example.client.api.path}"
        url = "http://localhost:8080",
//        fallback = FeignExampleClientApiFallback.class,
        fallbackFactory = FeignSampleClientApiWithFallbackFactory.FeignSampleClientApiFallbackFactory.class,
//        configuration = ClientConfig2.class
        configuration = FeignSampleClientApiWithFallbackFactory.FeignSampleClientApiWithFallbackConfig.class
)
public interface FeignSampleClientApiWithFallbackFactory {
    @PostMapping("info")
    String getInfo(@RequestBody SampleDto sampleDto);

    @GetMapping("proxy")
    String getInfoFromProxy(@RequestBody SampleDto sampleDto);

    @Slf4j
    @Component
    class FeignSampleClientApiFallbackFactory implements FallbackFactory<FeignSampleClientApiWithFallbackFactory> {
        @Override
        public FeignSampleClientApiWithFallbackFactory create(Throwable cause) {
            log.error(cause.getMessage(), cause);
            return new FeignSampleClientApiWithFallbackFactory() {
                @Override
                public String getInfo(SampleDto sampleDto) {
                    log.error(sampleDto.toString());
                    return null;
                }

                @Override
                public String getInfoFromProxy(SampleDto exampleDto) {
                    return null;
                }
            };
        }

    }

    @Configuration
    static class FeignSampleClientApiWithFallbackConfig {

        @Bean
        public ErrorDecoder errorDecoder(){
            return new ErrorDecoder.Default();
        }

//        @Bean
//        public Encoder encoder(){
//            return new Encoder.Default();
//        }
    }
}
