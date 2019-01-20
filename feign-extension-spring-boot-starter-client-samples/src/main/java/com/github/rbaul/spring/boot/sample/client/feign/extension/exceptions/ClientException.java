package com.github.rbaul.spring.boot.sample.client.feign.extension.exceptions;

import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientException extends RuntimeException {
    private ErrorDto errorDto;
}
