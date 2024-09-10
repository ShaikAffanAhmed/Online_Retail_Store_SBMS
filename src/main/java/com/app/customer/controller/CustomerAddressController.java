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

import com.app.customer.entity.CustomerAddress;
import com.app.customer.service.CustomerAddressService;

@RestController
@RequestMapping("/api/address")
public class CustomerAddressController {
	
	@Autowired
	private CustomerAddressService addressService;

	@PostMapping("/addCustomerAddress")
	public ResponseEntity<Long> addCustomerAddress(@RequestBody CustomerAddress customerAddress) {
		Long doorId = addressService.addCustomerAddress(customerAddress);
		return new ResponseEntity<>(doorId, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer/{doorid}")
	public ResponseEntity<Void> updateCustomerAddress(@RequestBody CustomerAddress customerAddress, @PathVariable Long doorid) {
		addressService.updateCustomerAddress(customerAddress, doorid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/customerId/{doorId}")
	public ResponseEntity<Void> deleteCustomerAddress(@PathVariable Long doorId) {
		addressService.deleteCustomerAddress(doorId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{doorid}")
	public ResponseEntity<CustomerAddress> getCustomerAddress(@PathVariable Long doorid) {
		CustomerAddress customerAddress = addressService.getCustomerAddress(doorid);
		return new ResponseEntity<>(customerAddress, HttpStatus.OK);
	}
}
