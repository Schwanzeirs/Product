package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.CartItemRequest;
import com.product.dto.CartResponse;
import com.product.services.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;

    @GetMapping
    public CartResponse createOrFind(@RequestParam Long userId) {
        return cartService.createOrFind(userId);
    }

    @PostMapping
    public CartResponse addItem(@RequestBody CartItemRequest request) {
        return cartService.addItem(request);
    }

    @DeleteMapping
    public CartResponse deleteItem(@RequestParam Long cartItemId) {
        return cartService.deleteItem(cartItemId);
    }

    @GetMapping("/qty")
    public CartResponse editQuantity(@RequestParam Long cartItemId, boolean isIncreament) {
        return cartService.updateItemQuantity(cartItemId, isIncreament);
    }
}
