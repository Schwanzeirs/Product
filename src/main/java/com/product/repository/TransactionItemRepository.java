package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.TransactionItem;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {
    
}
