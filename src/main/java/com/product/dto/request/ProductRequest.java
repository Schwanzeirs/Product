package com.product.dto.request;

import com.product.exception.validation.InvalidRequestException;

import lombok.Data;

@Data
public class ProductRequest implements RequestInterface {
    private String name;
    private String description;
    private String picture;
    private VariantRequest variantRequest;

    @Override
    public void validateParam() {
        validateName();
    }

    private void validateName() {
        if(name == null) {
            throw new InvalidRequestException(
                500, 
                "Product name cant be null", 
                "Insert product name"
            );
        }
    }
}
