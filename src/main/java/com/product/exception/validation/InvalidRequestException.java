package com.product.exception.validation;

import com.product.exception.BaseCustomException;

public class InvalidRequestException extends BaseCustomException {
    public InvalidRequestException(int code, String message, String description) {
        super(code, message, description);
    }
}
