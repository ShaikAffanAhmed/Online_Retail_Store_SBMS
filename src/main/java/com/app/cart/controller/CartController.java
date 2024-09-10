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

import com.app.cart.entity.Cart;
import com.app.cart.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/addCart")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		Cart cartDetails = cartService.addCart(cart);
		System.out.println("cartDetails: "+cartDetails);
		return new ResponseEntity<>(cartDetails, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable Integer id) {
		Cart cart = cartService.getCart(id);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<Cart>> getAllCart() {
//		List<Cart> cart = cartService.getAllCart();
//		return new ResponseEntity<>(cart, HttpStatus.OK);
//	}

	@PutMapping("/updateCart/{id}")
	public ResponseEntity<Void> updateCart(@RequestBody Cart cart, @PathVariable Integer id) {
		cartService.updateCart(cart, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteCart/{id}")
	public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
		cartService.deleteCart(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
