package com.inventory.inventory_review.inventory_review.impl;

import com.inventory.inventory_review.inventory_review.InventoryReview;
import com.inventory.inventory_review.inventory_review.InventoryReviewRepository;
import com.inventory.inventory_review.inventory_review.InventoryReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryReviewServiceImplementation implements InventoryReviewService {
    private final InventoryReviewRepository inventoryReviewRepository;

    public InventoryReviewServiceImplementation(InventoryReviewRepository inventoryReviewRepository) {
        this.inventoryReviewRepository = inventoryReviewRepository;
    }

    @Override
    public List<InventoryReview> getAllInventoryReview() {
        return inventoryReviewRepository.findAll();
    }

    @Override
    public InventoryReview addInventoryReview(InventoryReview inventoryReview) {
        return inventoryReviewRepository.save(inventoryReview);
    }

    @Override
    public InventoryReview updateInventoryReview(Long id, InventoryReview inventoryReview) {
        return inventoryReviewRepository.findById(id)
                .map(existingInventoryReview -> {
                    existingInventoryReview.setTitle(inventoryReview.getTitle());
                    existingInventoryReview.setDescription(inventoryReview.getDescription());
                    existingInventoryReview.setRating(inventoryReview.getRating());
                    return inventoryReviewRepository.save(existingInventoryReview);
                }).orElse(null);
    }

    @Override
    public InventoryReview getInventoryReview(Long id) {
        return inventoryReviewRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteInventoryReview(Long id) {
        if (inventoryReviewRepository.existsById(id)) {
            inventoryReviewRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
