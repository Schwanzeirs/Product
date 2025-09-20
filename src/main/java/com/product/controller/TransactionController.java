package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.request.TransactionRequest;
import com.product.dto.request.UpdateTransactionRequest;
import com.product.dto.response.ApiResponse;
import com.product.dto.response.HeaderResponse;
import com.product.services.TransactionService;
import com.product.util.ResponseBuilder;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @PostMapping("/checkout")
    public ResponseEntity<HeaderResponse> createTransaction(@RequestBody TransactionRequest request) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                transactionService.checkoutTransaction(request)
            )
        );
    }

    @PostMapping("/update")
    public ResponseEntity<HeaderResponse> updateTransaction(@RequestBody UpdateTransactionRequest request) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                transactionService.updateTransaction(request.getUserId(), request.getTransactionId(), request.getStatus())
            )
        );
    }
}
