package com.inventory.inventory_product.inventory_products;

import com.inventory.inventory_product.inventory_products.dto.InventoryProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-product")
public class InventoryProductController {
    private final InventoryProductService inventoryProductService;

    public InventoryProductController(InventoryProductService inventoryProductService){
        this.inventoryProductService = inventoryProductService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryProduct>> getAllInventoryProduct() {
        return new ResponseEntity<>(inventoryProductService.getAllInventoryProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryProductDTO> getInventoryProduct(@PathVariable Long id) {
        InventoryProduct extracted = inventoryProductService.getInventoryProduct(id);
        InventoryProductDTO response;

        if (extracted != null) {
            response = new InventoryProductDTO("Inventory product extracted successfully", extracted);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new InventoryProductDTO("Inventory product not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InventoryProductDTO> addInventoryProduct(@RequestBody InventoryProduct inventoryProduct) {
        InventoryProduct saved = inventoryProductService.addInventoryProduct(inventoryProduct);
        InventoryProductDTO response = new InventoryProductDTO("Inventory product saved successfully", saved);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryProductDTO> updateInventorCategory(@PathVariable Long id, @RequestBody InventoryProduct inventoryProduct) {
        InventoryProduct updated = inventoryProductService.updateInventoryProduct(id, inventoryProduct);
        InventoryProductDTO response;

        if (updated != null) {
            response = new InventoryProductDTO("Inventory product updated successfully", updated);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new InventoryProductDTO("Inventory product not found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryProductDTO> deleteInventoryProduct(@PathVariable Long id) {
        boolean deleted = inventoryProductService.deleteInventoryProduct(id);
        InventoryProductDTO response;

        if (deleted) {
            response = new InventoryProductDTO("Inventory product successfully deleted", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new InventoryProductDTO("Inventory product not found", null);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
