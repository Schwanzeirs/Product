package com.product.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.product.dto.response.ExceptionResponse;
import com.product.dto.response.HeaderResponse;
import com.product.util.ResponseBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @Autowired
    private ResponseBuilder responseBuilder;

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<HeaderResponse> handleException(Exception exception) {
        log.error("ERROR MESSAGE: {}, EXCEPTION CLASS NAME: {}",
                exception.getLocalizedMessage(),
                exception.getClass().getName()
        );

        return responseBuilder.buildExceptionResponse(
            new ExceptionResponse(
                500, 
                "Internal server error", 
                "Error", 
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        );
    }
}
