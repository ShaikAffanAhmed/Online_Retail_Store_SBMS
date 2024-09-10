package com.app.order.controller;

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

import com.app.order.entity.OrderLineItem;
import com.app.order.service.OrderLineItemService;

@RestController
@RequestMapping("/api")
public class OrderLineItemController {

	@Autowired
	private OrderLineItemService orderLineItemService;
	
	@PostMapping("/addOrdersLineItem")
	public ResponseEntity<OrderLineItem> addOrderLineitem(@RequestBody OrderLineItem orderLineItem) {
		OrderLineItem orderLineitemDetails = orderLineItemService.addOrderLineItem(orderLineItem);
		return new ResponseEntity<>(orderLineitemDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getOrdersLineitems/{id}")
	public ResponseEntity<OrderLineItem> getOrderLineItem(@PathVariable Integer id) {
		OrderLineItem orderLineItem = orderLineItemService.getOrderLineItem(id);
		return new ResponseEntity<>(orderLineItem, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<Order>> getAllOrder() {
//		List<Order> Order = orderLineItemService.getAllOrder();
//		return new ResponseEntity<>(Order, HttpStatus.OK);
//	}
	
	@PutMapping("/updateOrdersLineItem/{id}")
	public ResponseEntity<Void> updateOrderLineItem(@RequestBody OrderLineItem orderLineItem, @PathVariable Integer id) {
		orderLineItemService.updateOrderLineItem(orderLineItem, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteOrdersLineItems/{id}")
	public ResponseEntity<Void> deleteOrderLineItem(@PathVariable Integer id) {
		orderLineItemService.deleteOrderLineItem(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
