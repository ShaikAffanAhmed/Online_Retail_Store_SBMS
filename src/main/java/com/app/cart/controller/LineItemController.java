package com.app.cart.controller;

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

import com.app.cart.entity.LineItem;
import com.app.cart.service.LineItemService;

@RestController
@RequestMapping("/api")
public class LineItemController {

	@Autowired
	private LineItemService lineItemService;

	@PostMapping("/addlineItem")
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem lineItem) {
		LineItem lineItemDetails = lineItemService.addLineItem(lineItem);
		return new ResponseEntity<>(lineItemDetails, HttpStatus.CREATED);
	}

	@GetMapping("/lineItem/{id}")
	public ResponseEntity<LineItem> getLineItem(@PathVariable Integer id) {
		LineItem lineItem = lineItemService.getLineItem(id);
		return new ResponseEntity<>(lineItem, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<LineItem>> getAllLineItem() {
//		List<LineItem> lineItem = lineItemService.getAllLineItem();
//		return new ResponseEntity<>(lineItem, HttpStatus.OK);
//	}

	@PutMapping("/updatelineItem/{id}")
	public ResponseEntity<Void> updateLineItem(@RequestBody LineItem lineItem, @PathVariable Integer id) {
		lineItemService.updateLineItem(lineItem, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deletelineItemId/{id}")
	public ResponseEntity<Void> deleteLineItem(@PathVariable Integer id) {
		lineItemService.deleteLineItem(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
