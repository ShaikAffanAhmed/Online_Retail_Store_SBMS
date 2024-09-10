package com.app.inventory.controller;

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

import com.app.inventory.entity.Inventory;
import com.app.inventory.service.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/addinventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		Inventory inventoryDetails = inventoryService.addInventory(inventory);
		return new ResponseEntity<>(inventoryDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getinventory/{id}")
	public ResponseEntity<Inventory> getInventory(@PathVariable Integer id) {
		Inventory inventory = inventoryService.getInventory(id);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<Inventory>> getAllInventory() {
//		List<Inventory> inventory = inventoryService.getAllInventory();
//		return new ResponseEntity<>(inventory, HttpStatus.OK);
//	}

	@PutMapping("/updateinventory/{id}")
	public ResponseEntity<Void> updateInventory(@RequestBody Inventory inventory, @PathVariable Integer id) {
		inventoryService.updateInventory(inventory, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteinventory/{id}")
	public ResponseEntity<Void> deleteInventory(@PathVariable Integer id) {
		inventoryService.deleteInventory(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
