package com.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductRequest;
import com.product.entities.Product;
import com.product.entities.Variant;
import com.product.repository.ProductRepository;
import com.product.repository.VariantRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VariantRepository variantRepository;

    public Product insert(ProductRequest request) {
        Product result;
        Variant variant = null;
        try {
            if(request.getVariantRequest() != null) {
                variant = variantRepository.save(new Variant(request.getVariantRequest()));
            }
            result = productRepository.save(variant != null ? new Product(request, variant) : new Product(request));
        } catch (Exception e) {
            throw e;
        }

        return result;
    }

}
