package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.entity.OrderLineItem;
import com.app.order.repository.OrderLineItemRepository;

@Service
public class OrderLineItemService {

	@Autowired
	private OrderLineItemRepository orderLineItemRepository;
	
	public OrderLineItem addOrderLineItem(OrderLineItem orderLineItem) {
		OrderLineItem savedOrderLineItem = orderLineItemRepository.save(orderLineItem);
		return savedOrderLineItem;
	}

	public OrderLineItem getOrderLineItem(Integer id) {
		return orderLineItemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to search OrderLineItem with given Id " + id ));
	}

//	public List<Order> getAllOrder() {
//		return orderLineItemRepository.findAll();
//	}

	public void updateOrderLineItem(OrderLineItem orderLineItem, Integer id) {
		if (orderLineItemRepository.existsById(orderLineItem.getItemId())) {
			orderLineItemRepository.save(orderLineItem);
		} else {
			throw new RuntimeException("OrderLineItem not found with given Id " + id);
		}
	}

	public void deleteOrderLineItem(Integer id) {
		if (orderLineItemRepository.existsById(id)) {
			orderLineItemRepository.deleteById(id);
		} else {
			throw new RuntimeException("OrderLineItem not found with given Id " + id);
		}
	}
}
