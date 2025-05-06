package com.inventory.inventory_review.inventory_review.messaging.producer;

import com.inventory.inventory_review.inventory_review.InventoryReview;
import com.inventory.inventory_review.inventory_review.messaging.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendReviewMessage(InventoryReview review, double averageProductReviewRating) {
        ReviewMessage message = new ReviewMessage();
        message.setProductId(review.getProductId());
        message.setAverageProductReviewRating(averageProductReviewRating);
        rabbitTemplate.convertAndSend("productRatingQueue", message);
    }
}
