package com.product.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class TransactionRequest implements RequestInterface {
    private Long userId;
    private List<Long> cartItemId;

    @Override
    public void validateParam() {
        validateUserId();
        validateCartItemId();
    }

    private void validateUserId() {

    }

    private void validateCartItemId() {

    }
}
