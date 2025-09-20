package com.product.dto.dataDto;

import java.util.ArrayList;
import java.util.List;

import com.product.entities.Cart;
import com.product.entities.CartItem;

import lombok.Data;

@Data
public class CartResponse implements DataDto {
    private List<CartItemResponse> items = new ArrayList<>();

    public CartResponse(Cart cart) {
        if(cart.getItems() != null) {
            for(CartItem item : cart.getItems()) {
                this.items.add(new CartItemResponse(item));
            }
        }
    }
}
