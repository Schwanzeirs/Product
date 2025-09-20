package com.product.dto.request;

import lombok.Data;

@Data
public class UpdateTransactionRequest {
    private Long userId;
    private Long transactionId;
    private String status;
}
