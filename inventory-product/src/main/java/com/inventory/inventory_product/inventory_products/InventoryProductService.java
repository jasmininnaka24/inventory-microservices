package com.inventory.inventory_product.inventory_products;

import java.util.List;

public interface InventoryProductService {
    List<InventoryProduct> getAllInventoryProducts();
    InventoryProduct addInventoryProduct(InventoryProduct inventoryProduct);
    InventoryProduct updateInventoryProduct(Long id, InventoryProduct inventoryProduct);
    boolean deleteInventoryProduct(Long id);
    InventoryProduct getInventoryProduct(Long id);
}
