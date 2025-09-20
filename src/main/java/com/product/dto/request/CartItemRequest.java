package com.product.dto.request;

import lombok.Data;

@Data
public class CartItemRequest implements RequestInterface {
    private Long userId;
    private Long productId;
    private Long variantId;
    private Integer quantity;

    @Override
    public void validateParam() {
        validateUserId();
        validateProductId();
        validateVariantId();
        validateQuantity();
    }

    private void validateUserId() {

    }

    private void validateProductId() {

    }

    private void validateVariantId() {

    }

    private void validateQuantity() {

    }
}
