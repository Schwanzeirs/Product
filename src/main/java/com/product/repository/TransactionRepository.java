package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
