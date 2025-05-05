package com.inventory.inventory_review.inventory_review;

import java.util.List;

public interface InventoryReviewService {
    List<InventoryReview> getAllInventoryReview();
    InventoryReview addInventoryReview(InventoryReview inventoryReview);
    InventoryReview updateInventoryReview(Long id, InventoryReview inventoryReview);
    InventoryReview getInventoryReview(Long id);
    boolean deleteInventoryReview(Long id);
}
