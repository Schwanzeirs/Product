package com.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse implements HeaderResponse {
    private int code;
    private String message;
}
