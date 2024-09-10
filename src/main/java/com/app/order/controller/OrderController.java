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

import com.app.order.entity.Order;
import com.app.order.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addOrders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		Order orderDetails = orderService.addOrder(order);
		return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getOrders/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Integer id) {
		Order order = orderService.getOrder(id);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<Order>> getAllOrder() {
//		List<Order> Order = orderService.getAllOrder();
//		return new ResponseEntity<>(Order, HttpStatus.OK);
//	}
	
	@PutMapping("/updateOrders/{id}")
	public ResponseEntity<Void> updateOrder(@RequestBody Order order, @PathVariable Integer id) {
		orderService.updateOrder(order, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteOrders/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
		orderService.deleteOrder(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
