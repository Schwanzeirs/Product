package com.product.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.product.dto.response.ApiResponse;
import com.product.dto.response.ExceptionResponse;
import com.product.dto.response.HeaderResponse;

@Component
public class ResponseBuilder {
    
    public ResponseEntity<HeaderResponse> buildSuccessResponse(ApiResponse apiResponse) {
        return new ResponseEntity<>(
            apiResponse,
            HttpStatus.OK
        );
    }

    public ResponseEntity<HeaderResponse> buildExceptionResponse(ExceptionResponse exceptionResponse) {
        return new ResponseEntity<>(
            exceptionResponse,
            exceptionResponse.getStatus()
        );
    }
}
