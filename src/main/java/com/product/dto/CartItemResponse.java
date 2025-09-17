package com.product.dto;

import java.math.BigDecimal;

import com.product.entities.CartItem;

import lombok.Data;

@Data
public class CartItemResponse {
    private ProductResponse product;
    private VariantResponse variant;
    private Integer quantity;
    private BigDecimal subAmount;

    public CartItemResponse(CartItem cartItem) {
        this.product = new ProductResponse(cartItem.getProduct());
        product.setVariants(null);
        this.variant = new VariantResponse(cartItem.getVariant());
        this.quantity = cartItem.getQuantity();
        this.subAmount = cartItem.getSubAmount();
    }
}
