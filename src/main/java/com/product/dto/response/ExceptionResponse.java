package com.product.dto.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public class ExceptionResponse extends BaseResponse {
    private String description;
    @JsonIgnore
    private HttpStatus status;

    public ExceptionResponse(int code, 
                            String message, 
                            String description, 
                            HttpStatus status) {
        super(code, message);
        this.description = description;
        this.status = status;
    }
}