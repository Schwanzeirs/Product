package com.product.dto.dataDto;

import java.util.ArrayList;
import java.util.List;

import com.product.entities.Variant;

import lombok.Data;

@Data
public class VariantResponse implements DataDto {
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Integer quantity;
    private List<VariantResponse> children = new ArrayList<>();

    public VariantResponse(Variant variant) {
        this.id = variant.getId();
        this.name = variant.getName();
        this.type = variant.getType();
        this.price = variant.getPrice();
        this.quantity = variant.getQuantity();
        if(variant.getChildren() != null) {
            for(Variant child : variant.getChildren()) {
                this.children.add(new VariantResponse(child));
            }
        }
    }
}
