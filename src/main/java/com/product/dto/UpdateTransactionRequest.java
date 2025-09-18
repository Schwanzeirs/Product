package com.product.dto;

import lombok.Data;

@Data
public class UpdateTransactionRequest {
    private Long userId;
    private Long transactionId;
    private String status;
}
