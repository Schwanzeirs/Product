package com.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
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

    public ProductResponse insert(ProductRequest request) {
        Product product;
        Variant variant = null;
        try {
            product = productRepository.save(new Product(request));
            if(request.getVariantRequest() != null) {
                variant = variantRepository.save(new Variant(request.getVariantRequest(), product));
            }
            if(variant != null) {
                product.getVariants().add(variant);
                productRepository.save(product);
            }
        } catch (Exception e) {
            throw e;
        }

        return new ProductResponse(product);
    }

    public ProductResponse find(Long id) {
        return new ProductResponse(productRepository.findById(id).get());
    }

    public Variant findVariant(Long id) {
        return variantRepository.findById(id).get();
    }

    public void deleteVariant(Long id) {
        variantRepository.deleteById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
