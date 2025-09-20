package com.product.dto.request;

import com.product.exception.validation.InvalidRequestException;

import lombok.Data;

@Data
public class VariantRequest implements RequestInterface {
    private String name;
    private String type;
    private Double price; 
    private Integer quantity;
    private Long parentId;

    @Override
    public void validateParam() {
        validateName();
        validateType();
        validatePrice();
        validateQuantity();
    }

    private void validateName() {
        if(name == null) {
            throw new InvalidRequestException(
                500, 
                "Variant name cant be null", 
                "Insert variant name"
            );
        }
    }

    private void validateType() {
        if(type == null) {
            throw new InvalidRequestException(
                500, 
                "Variant type cant be null", 
                "Insert variant type"
            );
        }
    }

    private void validatePrice() {
        if(price == null || price.equals(Double.valueOf(0))) {
            throw new InvalidRequestException(
                500, 
                "Variant price cant be null or 0", 
                "Insert variant price"
            );
        }
    }

    private void validateQuantity() {
        if(quantity == null || quantity == 0) {
            throw new InvalidRequestException(
                500, 
                "Variant quantity cant be null or 0", 
                "Insert variant quantity"
            );
        }
    }
}
