package com.product.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private String picture;
    private VariantRequest variantRequest;
}
