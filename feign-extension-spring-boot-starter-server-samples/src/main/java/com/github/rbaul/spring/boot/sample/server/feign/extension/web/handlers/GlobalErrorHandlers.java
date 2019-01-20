package com.github.rbaul.spring.boot.sample.server.feign.extension.web.handlers;

import com.github.rbaul.spring.boot.sample.client.feign.extension.dtos.ErrorDto;
import com.github.rbaul.spring.boot.sample.client.feign.extension.exceptions.ClientException;
import com.github.rbaul.spring.boot.sample.client.feign.extension.exceptions.ServerException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandlers {


    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDto handleGlobalError(Exception ex) {
        log.error("Global error handler exception: ", ex);
        return ErrorDto.builder()
                .errorCode("UNKNOWN")
                .message(ex.getLocalizedMessage())
                .build();
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(feign.FeignException.class)
    public ErrorDto handleFeignError(feign.FeignException ex) {
        log.error("Global error handler exception: ", ex.getMessage());

        return ErrorDto.builder()
                .errorCode("UNKNOWN")
                .message(ex.getLocalizedMessage())
                .build();
    }

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(ClientException.class)
    public ErrorDto handleFeignError(ClientException ex) {
        log.error("ClientException1 error handler exception: ", ex.getMessage());

        return ex.getErrorDto();
    }

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(ServerException.class)
    public ErrorDto handleFeignError(ServerException ex) {
        log.error("ServerException error handler exception: ", ex.getMessage());

        return ex.getErrorDto();
    }

    @ExceptionHandler(HystrixRuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleControllerException(/*HttpServletRequest req, */HystrixRuntimeException ex) {
            HttpStatusCodeException exc = (HttpStatusCodeException)ex.getCause();
            return new ResponseEntity<>(exc.getResponseBodyAsString(), exc.getStatusCode());
//        }
//        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}