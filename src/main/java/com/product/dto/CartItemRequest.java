package com.product.dto;

import lombok.Data;

@Data
public class CartItemRequest {
    private Long userId;
    private Long productId;
    private Long variantId;
    private Integer quantity;
}
