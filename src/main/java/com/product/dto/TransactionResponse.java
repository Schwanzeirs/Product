package com.product.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.product.entities.Transaction;
import com.product.entities.TransactionItem;

import lombok.Data;

@Data
public class TransactionResponse {
    private String transacationNumber;
    private Instant transactionDate;
    private BigDecimal totalAmount;
    private String status;
    private List<TransactionItemResponse> items = new ArrayList<>();

    public TransactionResponse(Transaction transaction) {
        this.transacationNumber = transaction.getTransactionNumber();
        this.transactionDate = transaction.getTransactionDate();
        this.totalAmount = transaction.getTotalAmount();
        this.status = transaction.getStatus();
        for(TransactionItem item : transaction.getTransactionItems()) {
            items.add(new TransactionItemResponse(item));
        }
    }
}
