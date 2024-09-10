package com.app.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String customerAddress;
	private String customerBillingAddress;
	private String customerShippingAddress;
	
//	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<CustomerAddress> custAddress;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerBillingAddress() {
		return customerBillingAddress;
	}

	public void setCustomerBillingAddress(String customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}

	public String getCustomerShippingAddress() {
		return customerShippingAddress;
	}

	public void setCustomerShippingAddress(String customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}

//	public List<CustomerAddress> getCustAddress() {
//		return custAddress;
//	}
//
//	public void setCustAddress(List<CustomerAddress> custAddress) {
//		this.custAddress = custAddress;
//	}
//
//	 @Override
//	    public String toString() {
//	        return "Customer{" +
//	               "customerId=" + customerId +
//	               ", customerName='" + customerName + '\'' +
//	               ", customerAddress='" + customerAddress + '\'' +
//	               ", customerBillingAddress='" + customerBillingAddress + '\'' +
//	               ", customerShippingAddress='" + customerShippingAddress + '\'' +
//	               ", custAddress.size=" + (custAddress != null ? custAddress.size() : 0) +  // Avoid printing the entire list
//	               '}';
//	    }
//	
	
}
