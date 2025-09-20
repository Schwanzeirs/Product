package com.product.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long userId;
    private List<Long> cartItemId;
}
