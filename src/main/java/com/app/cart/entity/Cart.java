package com.app.cart.entity;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LineItem> lineItems;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public String toString() {
		// To prevent infinite recursion, avoid calling toString on LineItems directly
		return "Cart{" + "cartId=" + cartId + ", lineItems="
				+ (lineItems != null
						? lineItems.stream()
								.map(lineItem -> "LineItem{" + "lineItemId=" + lineItem.getItemId() + ", productId="
										+ lineItem.getProductId() + ", productName='" + lineItem.getProductName() + '\''
										+ ", quantity=" + lineItem.getQuantity() + ", price=" + lineItem.getPrice()
										+ '}')
								.collect(Collectors.toList())
						: null)
				+ '}';
	}

}
