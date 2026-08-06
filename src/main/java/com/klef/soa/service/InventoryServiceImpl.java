package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Inventory;
import com.klef.soa.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository repo;

    @Override
    public Inventory insertInventory(Inventory inventory) {
        return repo.save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {

        Optional<Inventory> optional = repo.findById(inventory.getInventoryId());

        if (optional.isPresent()) {

            Inventory inv = optional.get();

            inv.setName(inventory.getName());
            inv.setType(inventory.getType());
            inv.setStatus(inventory.getStatus());
            inv.setLocation(inventory.getLocation());

            return repo.save(inv);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Inventory> displayAll() {
        return repo.findAll();
    }

    @Override
    public Inventory displayById(Long inventoryId) {
        return repo.findById(inventoryId).orElse(null);
    }

    @Override
    public String deleteInventoryById(Long inventoryId) {

        boolean flag = repo.existsById(inventoryId);

        if (flag) {
            repo.deleteById(inventoryId);
            return "Inventory deleted successfully";
        }
        else {
            return "Inventory Id not found!";
        }
    }

    @Override
    public List<Inventory> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Inventory> findByType(String type) {
        return repo.findByType(type);
    }

	

}