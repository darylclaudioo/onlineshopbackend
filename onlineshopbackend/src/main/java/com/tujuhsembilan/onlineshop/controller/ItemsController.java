package com.tujuhsembilan.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.onlineshop.model.Items;
import com.tujuhsembilan.onlineshop.service.ItemsService;

@RestController
@RequestMapping("/api/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> items = itemsService.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Items> getItemById(@PathVariable Integer id) {
        Items items = itemsService.findById(id);
        if (items != null) {
            return ResponseEntity.ok(items);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Items createItem(@RequestBody Items items) {
        return itemsService.save(items);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Items> updateItem(@PathVariable Integer id, @RequestBody Items itemsDetails) {
        Items items = itemsService.findById(id);
        if (items != null) {
            items.setItemsName(itemsDetails.getItemsName());
            items.setItemsCode(itemsDetails.getItemsCode());
            items.setStock(itemsDetails.getStock());
            items.setPrice(itemsDetails.getPrice());
            items.setIsAvailable(itemsDetails.getIsAvailable());
            items.setLastReStock(itemsDetails.getLastReStock());
            return ResponseEntity.ok(itemsService.save(items));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        Items items = itemsService.findById(id);
        if (items != null) {
            itemsService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
