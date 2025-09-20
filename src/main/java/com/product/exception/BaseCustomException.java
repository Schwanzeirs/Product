package com.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseCustomException extends RuntimeException {
    private final int code;
    private final String message;
    private final String description;
}
