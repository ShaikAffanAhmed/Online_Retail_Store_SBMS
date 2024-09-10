package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.entity.Order;
import com.app.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order addOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		return savedOrder;
	}

	public Order getOrder(Integer id) {
		return orderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to search Order with given Id " + id ));
	}

//	public List<Order> getAllOrder() {
//		return orderRepository.findAll();
//	}

	public void updateOrder(Order order, Integer id) {
		if (orderRepository.existsById(order.getOrderId())) {
			orderRepository.save(order);
		} else {
			throw new RuntimeException("Order not found with given Id " + id);
		}
	}

	public void deleteOrder(Integer id) {
		if (orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
		} else {
			throw new RuntimeException("Order not found with given Id " + id);
		}
	}
}
