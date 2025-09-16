package com.product.dto;

import java.time.Instant;

import com.product.entities.Variant;

import lombok.Data;

@Data
public class VariantResponse {
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Integer quantity;
    private Instant createdAt;
    private Instant updatedAt;

    public VariantResponse(Variant variant) {
        this.id = variant.getId();
        this.name = variant.getName();
        this.type = variant.getType();
        this.price = variant.getPrice();
        this.quantity = variant.getQuantity();
        this.createdAt = variant.getCreatedAt();
        this.updatedAt = variant.getUpdatedAt();
    }
}
