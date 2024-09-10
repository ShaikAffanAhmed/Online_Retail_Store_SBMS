package com.app.product.controller;

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

import com.app.product.entity.Product;
import com.app.product.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/addproducts")
	public ResponseEntity<Product> addProduct(@RequestBody Product Product) {
		Product productDetails = productService.addProduct(Product);
		return new ResponseEntity<>(productDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getproducts/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
		Product Product = productService.getProduct(id);
		return new ResponseEntity<>(Product, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<Product>> getAllProduct() {
//		List<Product> Product = productService.getAllProduct();
//		return new ResponseEntity<>(Product, HttpStatus.OK);
//	}
	
	@PutMapping("/updateproducts/{id}")
	public ResponseEntity<Void> updateProduct(@RequestBody Product Product, @PathVariable Integer id) {
		productService.updateProduct(Product, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteproducts/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
