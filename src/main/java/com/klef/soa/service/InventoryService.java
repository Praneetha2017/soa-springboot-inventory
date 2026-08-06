package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Inventory;

public interface InventoryService {

    Inventory insertInventory(Inventory inventory);

    Inventory updateInventory( Inventory inventory);

    List<Inventory> displayAll();

    Inventory displayById(Long id);

    List<Inventory> findByName(String name);

    List<Inventory> findByType(String type);

	String deleteInventoryById(Long Id);
}