package com.inventory.inventory_review.inventory_review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryReviewRepository extends JpaRepository<InventoryReview, Long> {
    List<InventoryReview> findByProductId(Long productId);
}
