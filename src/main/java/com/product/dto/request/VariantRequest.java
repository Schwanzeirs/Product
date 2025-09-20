package com.product.dto.request;

import lombok.Data;

@Data
public class VariantRequest {
    private String name;
    private String type;
    private Double price; 
    private Integer quantity;
    private Long parentId;
}
