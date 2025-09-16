package com.product.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.product.entities.Product;
import com.product.entities.Variant;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String picture;
    private List<VariantResponse> variants = new ArrayList<>();
    private Instant createdAt;
    private Instant updatedAt;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.picture = product.getPicture();
        if(product.getVariants() != null) {
            for(Variant variant : product.getVariants()) {
                variants.add(new VariantResponse(variant));
            }
        }
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }
}
