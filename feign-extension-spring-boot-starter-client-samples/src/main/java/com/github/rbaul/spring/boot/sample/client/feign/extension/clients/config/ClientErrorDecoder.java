package com.github.rbaul.spring.boot.sample.client.feign.extension.clients.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.ErrorDto;
import com.github.rbaul.spring.boot.sample.client.feign.extension.exceptions.ClientException;
import com.github.rbaul.spring.boot.sample.client.feign.extension.exceptions.ServerException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static feign.FeignException.errorStatus;

@Slf4j
public class ClientErrorDecoder implements ErrorDecoder {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error(">> Error response: {}", response);
//        String body = null;
        ErrorDto errorDto = null;
        if (response.body() != null) {
            try {
//                body = Util.toString(response.body().asReader());
//                ErrorDto errorDto = objectMapper.readValue(body, ErrorDto.class);
//                o = objectMapper.readerFor(ErrorDto.class).readValue(body);
                errorDto = objectMapper.readerFor(ErrorDto.class).readValue(response.body().asReader());
                log.info(">>> converted");
            }catch (IOException ex) {
                log.info(">>> error");
            }
        }

        if (response.status() >= 400 && response.status() <= 499) {
            return new ClientException(errorDto);
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new ServerException(errorDto);
        }
        return errorStatus(methodKey, response);
    }
}