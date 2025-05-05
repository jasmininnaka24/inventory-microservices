package com.inventory.inventory_product.inventory_products.dto;

import com.inventory.inventory_product.inventory_products.InventoryProduct;

public class InventoryProductDTO {
    private String message;
    private InventoryProduct inventoryProduct;

    public InventoryProductDTO(String message, InventoryProduct inventoryProduct){
        this.message = message;
        this.inventoryProduct = inventoryProduct;
    }

    // getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InventoryProduct getInventoryProduct() {
        return inventoryProduct;
    }

    public void setInventoryProduct(InventoryProduct inventoryProduct) {
        this.inventoryProduct = inventoryProduct;
    }
}
