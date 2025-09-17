package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.CartItem;

public interface CartItemRepository extends JpaRepository <CartItem, Long> {
    
}
