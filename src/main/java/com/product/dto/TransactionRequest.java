package com.product.dto;

import java.util.List;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long userId;
    private List<Long> cartItemId;
}
