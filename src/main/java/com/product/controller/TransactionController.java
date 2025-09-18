package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.TransactionRequest;
import com.product.dto.TransactionResponse;
import com.product.dto.UpdateTransactionRequest;
import com.product.services.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/checkout")
    public TransactionResponse createTransaction(@RequestBody TransactionRequest request) {
        return transactionService.checkoutTransaction(request);
    }

    @PostMapping("/update")
    public TransactionResponse updateTransaction(@RequestBody UpdateTransactionRequest request) {
        return transactionService.updateTransaction(request.getUserId(), request.getTransactionId(), request.getStatus());
    }
}
