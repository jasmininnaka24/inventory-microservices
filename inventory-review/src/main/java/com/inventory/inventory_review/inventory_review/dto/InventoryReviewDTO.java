package com.inventory.inventory_review.inventory_review.dto;

import com.inventory.inventory_review.inventory_review.InventoryReview;

public class InventoryReviewDTO {
    private String message;
    private InventoryReview data;

    public InventoryReviewDTO(String message, InventoryReview data) {
        this.message = message;
        this.data = data;
    }

    // getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InventoryReview getData() {
        return data;
    }

    public void setData(InventoryReview data) {
        this.data = data;
    }
}
