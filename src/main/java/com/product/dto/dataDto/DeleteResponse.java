package com.product.dto.dataDto;

import lombok.Data;

@Data
public class DeleteResponse implements DataDto {
    private String message;

    public DeleteResponse(String message) {
        this.message = message;
    }
}
