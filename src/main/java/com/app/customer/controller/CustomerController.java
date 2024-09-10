package com.app.customer.controller;

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

import com.app.customer.entity.Customer;
import com.app.customer.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer custDetails = customerService.addCustomer(customer);
		return new ResponseEntity<>(custDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.getCustomer(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<List<Customer>> getAllCustomer() {
//		List<Customer> customer = customerService.getAllCustomer();
//		return new ResponseEntity<>(customer, HttpStatus.OK);
//	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
		customerService.updateCustomer(customer, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/customerId/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
