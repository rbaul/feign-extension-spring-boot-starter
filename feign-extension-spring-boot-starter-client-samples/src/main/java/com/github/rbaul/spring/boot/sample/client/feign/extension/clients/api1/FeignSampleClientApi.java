package com.github.rbaul.spring.boot.sample.client.feign.extension.clients.api1;

import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.config.ClientDefaultConfig;
import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.SampleDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "feign-example-client",
        path = "/",
//		fallbackFactory = VnfPackageStoreClient.VnfPackageStoreClientFallbackFactory.class,
//		primary = false,
//		decode404 = true,
        url = "${sample.client.api.path:http://localhost:8080}",
//        url = "http://localhost:8080"//,
//        fallback = FeignExampleClientApiFallback.class,
//        fallbackFactory = FeignSampleClientApiFallbackFactory.class
        configuration = ClientDefaultConfig.class
)
public interface FeignSampleClientApi {
    @PostMapping("info")
    String getInfo(@RequestBody SampleDto exampleDto);

    @GetMapping("proxy")
    String getInfoFromProxy(@RequestBody SampleDto exampleDto);

    @GetMapping("page")
    Page<String> getPageInfo(Pageable pageable);

    @GetMapping("page")
    Page<String> getPageInfo();
}
