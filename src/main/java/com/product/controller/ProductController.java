package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductRequest;
import com.product.entities.Product;
import com.product.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product insert(@RequestBody ProductRequest request) {
        Product result;
        try {
            result = productService.insert(request);
        } catch (Exception e) {
            throw e;
        }

        return result;
    }
}
