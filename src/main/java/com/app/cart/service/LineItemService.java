package com.app.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cart.entity.LineItem;
import com.app.cart.repository.LineItemRepository;

@Service
public class LineItemService {

	@Autowired
	private LineItemRepository lineItemRepository;

	public LineItem addLineItem(LineItem lineItem) {
		LineItem savedLineItem = lineItemRepository.save(lineItem);
		return savedLineItem;
	}

	public LineItem getLineItem(Integer id) {
		return lineItemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to search LineItem with given Id" + id));
	}

//	public List<LineItem> getAllLineItem() {
//		return lineItemRepository.findAll();
//	}

	public void updateLineItem(LineItem lineItem, Integer id) {
		if (lineItemRepository.existsById(lineItem.getItemId())) {
			lineItemRepository.save(lineItem);
		} else {
			throw new RuntimeException("LineItem not found with given Id" + id);
		}
	}

	public void deleteLineItem(Integer id) {
		if (lineItemRepository.existsById(id)) {
			lineItemRepository.deleteById(id);
		} else {
			throw new RuntimeException("LineItem not found with given Id" + id);
		}
	}
}
