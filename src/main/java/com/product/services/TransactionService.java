package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.dataDto.TransactionResponse;
import com.product.dto.request.TransactionRequest;
import com.product.entities.Cart;
import com.product.entities.CartItem;
import com.product.entities.Transaction;
import com.product.entities.TransactionItem;
import com.product.entities.Variant;
import com.product.repository.*;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionItemRepository transactionItemRepository;

    @Autowired
    private VariantRepository variantRepository;

    public TransactionResponse checkoutTransaction(TransactionRequest request) {
        try {
            Transaction transaction = transactionRepository.save(new Transaction(request.getUserId(), "Waiting"));
            Cart cart = cartRepository.findByUserId(request.getUserId()).get();

            if (request.getCartItemId() != null) {
                List<CartItem> selectedItems = cart.getItems().stream().filter(ci -> request.getCartItemId().contains(ci.getId())).toList();
                for (CartItem item : selectedItems) {
                    transaction.addItems(transactionItemRepository.save(new TransactionItem(item, transaction)));
                }
                cart.getItems().removeAll(selectedItems);
            } else {
                for (CartItem item : cart.getItems()) {
                    transaction.addItems(transactionItemRepository.save(new TransactionItem(item, transaction)));
                }
                cart.getItems().clear();
            }
            cartRepository.save(cart);
            return new TransactionResponse(transaction);
        } catch (Exception e) {
            throw e;
        }
    }

    public TransactionResponse updateTransaction(Long userId, Long transactionId, String status) {
        try {
            Transaction transaction = transactionRepository.findById(transactionId).get();
            transaction.setStatus(status);
            transactionRepository.save(transaction);

            if (status.equals("Complete")) {
                for (TransactionItem item : transaction.getTransactionItems()) {
                    Variant variant = item.getVariant();
                    variant.setQuantity(item.getVariant().getQuantity() - item.getQuantity());
                    variantRepository.save(variant);
                }
            }

            return new TransactionResponse(transaction);
        } catch (Exception e) {
            throw e;
        }

    }
}
