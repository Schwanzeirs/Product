package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
