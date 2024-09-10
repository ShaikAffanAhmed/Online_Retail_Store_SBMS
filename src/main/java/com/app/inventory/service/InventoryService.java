package com.app.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.entity.Inventory;
import com.app.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public Inventory addInventory(Inventory inventory) {
		Inventory savedInventory = inventoryRepository.save(inventory);
		return savedInventory;
	}

	public Inventory getInventory(Integer id) {
		return inventoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to search Inventory with given Id"));
	}

	// public List<Inventory> getAllInventory() {
//		return inventoryRepository.findAll();
//	}

	public void updateInventory(Inventory inventory, Integer id) {
		if (inventoryRepository.existsById(inventory.getInventoryId())) {
			inventoryRepository.save(inventory);
		} else {
			throw new RuntimeException("Inventory not found with given Id" + id);
		}
	}

	public void deleteInventory(Integer id) {
		if (inventoryRepository.existsById(id)) {
			inventoryRepository.deleteById(id);
		} else {
			throw new RuntimeException("Inventory not found with given Id" + id);
		}
	}


}
