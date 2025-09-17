package com.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
