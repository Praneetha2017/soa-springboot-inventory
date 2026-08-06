package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Inventory;
import com.klef.soa.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/")
    public String demo() {
        return "Spring Boot Project";
    }

    @PostMapping("/add")
    public ResponseEntity<Inventory> insertInventory(@RequestBody Inventory inventory) {
        Inventory inv = service.insertInventory(inventory);
        return ResponseEntity.status(201).body(inv);
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<Inventory>> displayAllInventory() {
        List<Inventory> inventory = service.displayAll();
        return ResponseEntity.status(200).body(inventory);
    }

    @GetMapping("/display")
    public ResponseEntity<?> displayInventoryById(@RequestParam Long inventoryId) {
        Inventory inventory = service.displayById(inventoryId);

        if (inventory != null) {
            return ResponseEntity.status(200).body(inventory);
        } else {
            return ResponseEntity.status(404).body("Inventory ID Not Found");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
        Inventory inv = service.updateInventory(inventory);

        if (inv != null) {
            return ResponseEntity.ok(inv);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inventory ID Not Found");
        }
    }

    @DeleteMapping("/delete/{inventoryId}")
    public ResponseEntity<String> deleteInventoryById(@PathVariable Long inventoryId) {
        String message = service.deleteInventoryById(inventoryId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<Inventory>> displayInventoryByName(@PathVariable String name) {
        List<Inventory> inventory = service.findByName(name);
        return ResponseEntity.status(200).body(inventory);
    }

    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Inventory>> displayInventoryByType(@PathVariable String type) {
        List<Inventory> inventory = service.findByType(type);
        return ResponseEntity.status(200).body(inventory);
    }
}