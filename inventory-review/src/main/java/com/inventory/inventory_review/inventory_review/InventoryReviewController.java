package com.inventory.inventory_review.inventory_review;

import com.inventory.inventory_review.inventory_review.dto.InventoryReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-review")
public class InventoryReviewController {
    private final InventoryReviewService inventoryReviewService;

    public InventoryReviewController(InventoryReviewService inventoryReviewService){
        this.inventoryReviewService = inventoryReviewService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryReview>> getAllInventoryReview() {
        return ResponseEntity.ok(inventoryReviewService.getAllInventoryReview());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryReviewDTO> getInventoryReview(@PathVariable Long id){
        InventoryReview extracted = inventoryReviewService.getInventoryReview(id);
        InventoryReviewDTO response = new InventoryReviewDTO("Extracted details: ", extracted);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryReviewDTO> addInventoryReview(@RequestBody InventoryReview inventoryReview) {
        InventoryReview saved = inventoryReviewService.addInventoryReview(inventoryReview);
        InventoryReviewDTO response = new InventoryReviewDTO("Inventory review was added successfully", saved);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryReviewDTO> updateInventoryReview(@PathVariable Long id, @RequestBody InventoryReview updatedInventoryReview) {
        InventoryReview updated = inventoryReviewService.updateInventoryReview(id, updatedInventoryReview);
        InventoryReviewDTO response;

        if (updated != null) {
            response = new InventoryReviewDTO("Inventory review was updated successfully", updated);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryReviewDTO> deleteInventoryReview(@PathVariable Long id) {
        boolean deleted = inventoryReviewService.deleteInventoryReview(id);
        InventoryReviewDTO response;

        if (deleted) {
            response = new InventoryReviewDTO("Inventory review deleted successfully", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
