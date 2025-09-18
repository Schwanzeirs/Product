package com.product.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionNumber;
    private Instant transactionDate;
    private Long userId;

    @Column(name = "total_amount")
    private BigDecimal totalAmount = BigDecimal.valueOf(0);
    
    private String status;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionItem> transactionItems = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    public Transaction(Long userId, String status) {
        this.userId = userId;
        this.transactionDate = Instant.now();
        this.transactionNumber = String.valueOf(Instant.now().toEpochMilli());
        this.status = status;
    }

    public void addItems(TransactionItem item) {
        this.transactionItems.add(item);
        this.totalAmount = this.totalAmount.add(item.getSubAmount());
    }
    
}
