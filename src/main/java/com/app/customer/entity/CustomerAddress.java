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
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long DoorNo;
	private String streetName;
	private String layout;
	private String city;
	private String pincode;
	
//	@ManyToOne
//	@JoinColumn(name="customerId")
//	private Customer customer;

	
	public Long getDoorNo() {
		return DoorNo;
	}

	public void setDoorNo(Long doorNo) {
		DoorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	@Override
//    public String toString() {
//        return "CustomerAddress{" +
//               "DoorNo=" + DoorNo +
//               ", streetName='" + streetName + '\'' +
//               ", layout='" + layout + '\'' +
//               ", city='" + city + '\'' +
//               ", pincode='" + pincode + '\'' +
//               // Avoid printing customer to prevent recursion
//               '}';
//    }
	
}
