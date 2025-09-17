package com.product.dto;

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

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.picture = product.getPicture();
        if(product.getVariants() != null) {
            for(Variant variant : product.getVariants()) {
                if(variant.getParent() == null) {
                    variants.add(new VariantResponse(variant));
                }
            }
        }
    }
}
