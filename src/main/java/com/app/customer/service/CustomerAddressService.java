package com.app.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customer.entity.CustomerAddress;
import com.app.customer.repository.CustomerAddressRepository;

@Service
public class CustomerAddressService {

	@Autowired
	private CustomerAddressRepository addressRepository;
	
	public Long addCustomerAddress(CustomerAddress customerAddress) {
    	CustomerAddress savedCustomerAddress = addressRepository.save(customerAddress);
        return savedCustomerAddress.getDoorNo();
    }

    public void updateCustomerAddress(CustomerAddress customerAddress, Long doorid) {
        if (addressRepository.existsById(customerAddress.getDoorNo())) {
        	addressRepository.save(customerAddress);
        } else {
            throw new RuntimeException("CustomerAddress not found with given Id");
        }
    }

    public void deleteCustomerAddress(Long doorid) {
        if (addressRepository.existsById(doorid)) {
        	addressRepository.deleteById(doorid);
        } else {
            throw new RuntimeException("CustomerAddress not found with given Id");
        }
    }
    
	public CustomerAddress getCustomerAddress(Long doorid) {
		return addressRepository.findById(doorid)
				.orElseThrow(() -> new RuntimeException("Unable to search customerAddress with given Id"));
	}
}
