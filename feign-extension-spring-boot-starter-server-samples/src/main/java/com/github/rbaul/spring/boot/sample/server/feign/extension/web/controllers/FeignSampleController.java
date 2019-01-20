package com.github.rbaul.spring.boot.sample.server.feign.extension.web.controllers;

import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.SampleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FeignSampleController {

    @Autowired
    private HttpServletRequest request;

    @PostMapping("info")
    public String getInfo(@Validated @RequestBody SampleDto sampleDto){
        Enumeration<String> headerNames = request.getHeaderNames();
        log.info(">>> headerNames: {}", headerNames);
        return sampleDto.getName();
    }

    @GetMapping("page")
    public Page<String> getPageInfo(Pageable pageable){
        return new PageImpl<>(Arrays.asList("R", "A"), pageable, pageable.getPageSize());
    }

}
