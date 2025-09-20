package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.request.CartItemRequest;
import com.product.dto.response.ApiResponse;
import com.product.dto.response.HeaderResponse;
import com.product.services.CartService;
import com.product.util.ResponseBuilder;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @GetMapping
    public ResponseEntity<HeaderResponse> createOrFind(@RequestParam Long userId) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                cartService.createOrFind(userId)
            )
        );
    }

    @PostMapping
    public ResponseEntity<HeaderResponse> addItem(@RequestBody CartItemRequest request) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                cartService.addItem(request)
            )
        );
    }

    @DeleteMapping
    public ResponseEntity<HeaderResponse> deleteItem(@RequestParam Long cartItemId) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                cartService.deleteItem(cartItemId)
            )
        );
    }

    @GetMapping("/qty")
    public ResponseEntity<HeaderResponse> editQuantity(@RequestParam Long cartItemId, boolean isIncreament) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                cartService.updateItemQuantity(cartItemId, isIncreament)
            )
        );
    }
}
