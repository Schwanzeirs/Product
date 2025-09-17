package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.entities.Variant;
import com.product.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse insert(@RequestBody ProductRequest request) {
        ProductResponse result;
        try {
            result = productService.insert(request);
        } catch (Exception e) {
            throw e;
        }

        return result;
    }

    @GetMapping
    public ProductResponse find(@RequestParam Long id) {
        return productService.find(id);
    }

    @GetMapping("/variant")
    public Variant findById(@RequestParam Long id) {
        return productService.findVariant(id);
    }

    @DeleteMapping("/variant")
    public void deleteVariant(@RequestParam Long id) {
        productService.deleteVariant(id);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }
}
