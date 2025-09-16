package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Variant;

public interface VariantRepository extends JpaRepository<Variant, Long> {
    
}
