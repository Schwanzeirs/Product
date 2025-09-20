package com.product.dto.dataDto;

import java.math.BigDecimal;

import com.product.entities.TransactionItem;

import lombok.Data;

@Data
public class TransactionItemResponse implements DataDto {
    private ProductResponse product;
    private VariantResponse variant;
    private Integer quantity;
    private BigDecimal subAmount;

    public TransactionItemResponse(TransactionItem transactionItem) {
        this.product = new ProductResponse(transactionItem.getProduct());
        product.setVariants(null);
        this.variant = new VariantResponse(transactionItem.getVariant());
        this.quantity = transactionItem.getQuantity();
        this.subAmount = transactionItem.getSubAmount();
    }
}
