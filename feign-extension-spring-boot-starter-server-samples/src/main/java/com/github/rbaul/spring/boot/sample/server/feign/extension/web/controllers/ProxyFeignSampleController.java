package com.github.rbaul.spring.boot.sample.server.feign.extension.web.controllers;

import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.FeignSampleClientApi;
import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.FeignSampleClientApiWithFallback;
import com.github.rbaul.spring.boot.sample.client.feign.extension.clients.FeignSampleClientApiWithFallbackFactory;
import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.SampleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProxyFeignSampleController {

    private final FeignSampleClientApi feignExampleClientApi;

    private final FeignSampleClientApiWithFallback feignExampleClientApiWithFallback;

    private final FeignSampleClientApiWithFallbackFactory feignExampleClientApiWithFallbackFactory;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("proxy-page")
    public Page<String> getPageFromProxy(){
        Pageable pageable = new PageRequest(1, 2);
        return feignExampleClientApi.getPageInfo(pageable);
    }

    @GetMapping("proxy-info")
    public String getInfoFromProxy(){
        Enumeration<String> headerNames = request.getHeaderNames();
        log.info(">>> headerNames: {}", headerNames);
        return feignExampleClientApi.getInfo(SampleDto.builder().name("sdas").build());
    }

    @GetMapping("proxy-fallback-info")
    public String getInfoFromProxyWithFalback(){
        return feignExampleClientApiWithFallback.getInfo(SampleDto.builder().build());
    }

    @GetMapping("proxy-fallback-factory-info")
    public String getInfoFromProxyWithFallbackFactory(){
        return feignExampleClientApiWithFallbackFactory.getInfo(SampleDto.builder().build());
    }

}
