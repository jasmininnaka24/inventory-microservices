package com.inventory.inventory_product.inventory_products.impl;

import com.inventory.inventory_product.inventory_products.InventoryProduct;
import com.inventory.inventory_product.inventory_products.InventoryProductRepository;
import com.inventory.inventory_product.inventory_products.InventoryProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryProductServiceImplementation implements InventoryProductService {
    private final InventoryProductRepository inventoryProductRepository;

    public InventoryProductServiceImplementation(InventoryProductRepository inventoryProductRepository) {
        this.inventoryProductRepository = inventoryProductRepository;
    }

    @Override
    public List<InventoryProduct> getAllInventoryProducts(){
        return inventoryProductRepository.findAll();
    }

    @Override
    public InventoryProduct getInventoryProduct(Long id){
        return inventoryProductRepository.findById(id).orElse(null);
    }

    @Override
    public InventoryProduct addInventoryProduct(InventoryProduct inventoryProduct){
        return inventoryProductRepository.save(inventoryProduct);
    }

    @Override
    public InventoryProduct updateInventoryProduct(Long id, InventoryProduct inventoryProduct){
        return inventoryProductRepository.findById(id)
                .map(existingInventoryProduct -> {
                    existingInventoryProduct.setProductName(inventoryProduct.getProductName());
                    existingInventoryProduct.setDescription(inventoryProduct.getDescription());
                    existingInventoryProduct.setOriginalPrice(inventoryProduct.getOriginalPrice());
                    return inventoryProductRepository.save(existingInventoryProduct);
                }).orElse(null);
    }

    @Override
    public boolean deleteInventoryProduct(Long id){
        if(inventoryProductRepository.existsById(id)) {
            inventoryProductRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
