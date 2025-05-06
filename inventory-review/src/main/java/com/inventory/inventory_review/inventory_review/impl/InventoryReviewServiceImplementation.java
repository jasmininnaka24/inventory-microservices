package com.inventory.inventory_review.inventory_review.impl;

import com.inventory.inventory_review.inventory_review.InventoryReview;
import com.inventory.inventory_review.inventory_review.InventoryReviewRepository;
import com.inventory.inventory_review.inventory_review.InventoryReviewService;
import com.inventory.inventory_review.inventory_review.messaging.dto.ReviewMessage;
import com.inventory.inventory_review.inventory_review.messaging.producer.ReviewMessageProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryReviewServiceImplementation implements InventoryReviewService {
    private final InventoryReviewRepository inventoryReviewRepository;
    private final ReviewMessageProducer reviewMessageProducer;

    public InventoryReviewServiceImplementation(InventoryReviewRepository inventoryReviewRepository, ReviewMessageProducer reviewMessageProducer) {
        this.inventoryReviewRepository = inventoryReviewRepository;
        this.reviewMessageProducer = reviewMessageProducer;
    }

    @Override
    public List<InventoryReview> getAllInventoryReview() {
        return inventoryReviewRepository.findAll();
    }

    public double calculateAverageRating(Long productId) {
        List<InventoryReview> reviews = inventoryReviewRepository.findByProductId(productId);
        return reviews.stream().mapToDouble(InventoryReview::getRating).average().orElse(0.0);
    }

    @Override
    public InventoryReview addInventoryReview(InventoryReview inventoryReview) {
        InventoryReview saved = inventoryReviewRepository.save(inventoryReview);
        double averageProductReviewRating = calculateAverageRating(saved.getProductId());

        // Send message to RabbitMQ after saving
        reviewMessageProducer.sendReviewMessage(saved, averageProductReviewRating);
        return saved;
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
