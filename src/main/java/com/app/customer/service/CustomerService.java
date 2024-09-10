package com.app.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customer.entity.Customer;
import com.app.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		Customer savedCustomerDetails = customerRepository.save(customer);
		return savedCustomerDetails;
	}

	public Customer getCustomer(Integer id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to search customer with given Id"));
	}

//	public List<Customer> getAllCustomer() {
//		return customerRepository.findAll();
//	}

	public void updateCustomer(Customer customer, Integer id) {
		if (customerRepository.existsById(customer.getCustomerId())) {
			customerRepository.save(customer);
		} else {
			throw new RuntimeException("Customer not found with given Id");
		}
	}

	public void deleteCustomer(Integer id) {
		if (customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
		} else {
			throw new RuntimeException("Customer not found with given Id");
		}
	}

}
