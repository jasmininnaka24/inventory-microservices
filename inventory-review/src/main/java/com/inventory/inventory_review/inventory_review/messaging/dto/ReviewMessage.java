package com.inventory.inventory_review.inventory_review.messaging.dto;

public class ReviewMessage {
    private Long productId;
    private double averageProductReviewRating;

    public ReviewMessage(Long productId, double averageProductReviewRating) {
        this.productId = productId;
        this.averageProductReviewRating = averageProductReviewRating;
    }

    public ReviewMessage() {

    }

    // getters and setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getAverageProductReviewRating() {
        return averageProductReviewRating;
    }

    public void setAverageProductReviewRating(double averageProductReviewRating) {
        this.averageProductReviewRating = averageProductReviewRating;
    }
}
