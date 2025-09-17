package com.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.CartItemRequest;
import com.product.dto.CartResponse;
import com.product.entities.Cart;
import com.product.entities.CartItem;
import com.product.entities.Product;
import com.product.entities.Variant;
import com.product.repository.CartItemRepository;
import com.product.repository.CartRepository;
import com.product.repository.ProductRepository;
import com.product.repository.VariantRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartResponse createOrFind(Long userId) {
        Cart cart;
        try {
            cart = cartRepository.findByUserId(userId).isPresent() ? cartRepository.findByUserId(userId).get() : cartRepository.save(new Cart(userId));
        } catch (Exception e) {
            throw e;
        }

        return new CartResponse(cart);
    }

    public CartResponse addItem(CartItemRequest request) {
        Cart cart;
        try {
            cart = cartRepository.findByUserId(request.getUserId()).isPresent() ? cartRepository.findByUserId(request.getUserId()).get() : cartRepository.save(new Cart(request.getUserId()));
            Product product = productRepository.findById(request.getProductId()).get();
            Variant variant = variantRepository.findById(request.getVariantId()).get();
            CartItem item = new CartItem(request, cart, product, variant);
            cartItemRepository.save(item);
            cart.addItem(item);
            cartRepository.save(cart);
        } catch (Exception e) {
            throw e;
        }

        return new CartResponse(cart);
    }

    public CartResponse deleteItem(Long cartItemId) {
        Cart cart;
        CartItem cartItem;
        try {
            cartItem = cartItemRepository.findById(cartItemId).get();
            cart = cartItem.getCart();
            for ( int i = 0 ; i < cart.getItems().size(); i++) {
                if(cart.getItems().get(i).getId().equals(cartItem.getId())) {
                    cart.getItems().remove(i);
                }
            }
            cartItemRepository.deleteById(cartItemId);
            cartRepository.save(cart);
        } catch (Exception e) {
            throw e;
        }

        return new CartResponse(cart);
    }

    public CartResponse updateItemQuantity(Long cartItemId, boolean isIncreament) {
        CartItem cartItem;
        try {
            cartItem = cartItemRepository.findById(cartItemId).get();
            if(isIncreament) {
                cartItem.addQuantity();
            } else {
                cartItem.substractQuantity();
            }
            cartItemRepository.save(cartItem);
        } catch (Exception e) {
            throw e;
        }

        return new CartResponse(cartItem.getCart());
    }
}
