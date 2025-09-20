package com.product.dto.response;

import com.product.dto.dataDto.DataDto;

import lombok.Getter;

@Getter
public class ApiResponse extends BaseResponse {
    private DataDto data;

    public ApiResponse(int code, String message, DataDto data) {
        super(code, message);
        this.data = data;
    }
}
