package com.product.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.product.dto.request.CartItemRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "variant_id", nullable = false)
    private Variant variant;
    
    private Integer quantity;

    @Column(name = "sub_amount")
    private BigDecimal subAmount;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    public CartItem(CartItemRequest request, Cart cart, Product product, Variant variant) {
        this.cart = cart;
        this.product = product;
        this.variant = variant;
        this.quantity = request.getQuantity();
        this.subAmount = BigDecimal.valueOf(variant.getPrice() * this.quantity);
    }

    public void addQuantity() {
        this.subAmount = this.subAmount.add(BigDecimal.valueOf(this.getVariant().getPrice()));
        this.quantity++;
    }

    public void substractQuantity() {
        this.subAmount = this.subAmount.subtract(BigDecimal.valueOf(this.getVariant().getPrice()));
        this.quantity--;
    }
}
