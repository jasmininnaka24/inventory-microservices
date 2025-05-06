package com.inventory.inventory_product.inventory_products.messaging.dto;

public class ReviewMessage {
    private Long productId;
    private double averageProductReviewRating;

    public ReviewMessage() {
    }

    public ReviewMessage(Long productId, double averageProductReviewRating) {
        this.productId = productId;
        this.averageProductReviewRating = averageProductReviewRating;
    }

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
