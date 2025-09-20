package com.product.dto.request;

import lombok.Data;

@Data
public class UpdateTransactionRequest implements RequestInterface {
    private Long userId;
    private Long transactionId;
    private String status;

    @Override
    public void validateParam() {
        validateUserId();
        validateTransactionId();
        validateStatus();
    }

    private void validateUserId() {

    }

    private void validateTransactionId() {

    }

    private void validateStatus() {

    }
}
