package com.inventory.inventory_product.inventory_products.messaging.consumer;

import com.inventory.inventory_product.inventory_products.InventoryProductService;
import com.inventory.inventory_product.inventory_products.messaging.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {
    private final InventoryProductService inventoryProductService;

    public ReviewMessageConsumer(InventoryProductService inventoryProductService) {
        this.inventoryProductService = inventoryProductService;
    }

    @RabbitListener(queues = "productRatingQueue")
    public void consumeReviewMessage(ReviewMessage reviewMessage) {
        System.out.println("Received from RabbitMQ: productId=" + reviewMessage.getProductId() + ", rating=" + reviewMessage.getAverageProductReviewRating());
        inventoryProductService.updateAverageRating(reviewMessage);
    }
}
