package com.app.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cart.entity.Cart;
import com.app.cart.entity.LineItem;
import com.app.cart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public Cart addCart(Cart cart) {
		System.out.println("cart: " + cart);
		if (cart.getLineItems() != null) {
			for (LineItem item : cart.getLineItems()) {
				item.setCart(cart);
			}
		}

		Cart savedCart = cartRepository.save(cart);
		System.out.println("SavedCart: " + savedCart);
		return savedCart;
	}

	public Cart getCart(Integer id) {
		return cartRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to search Cart with given Id" + id));
	}

//	public List<Cart> getAllCart() {
//		return cartRepository.findAll();
//	}

	public void updateCart(Cart cart, Integer id) {
		if (cartRepository.existsById(cart.getCartId())) {
			cartRepository.save(cart);
		} else {
			throw new RuntimeException("Cart not found with given Id" + id);
		}
	}

	public void deleteCart(Integer id) {
		if (cartRepository.existsById(id)) {
			cartRepository.deleteById(id);
		} else {
			throw new RuntimeException("Cart not found with given Id" + id);
		}
	}
}
