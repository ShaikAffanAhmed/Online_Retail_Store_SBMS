package com.app.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.product.entity.Product;
import com.app.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	public Product getProduct(Integer id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to search Product with given Id"));
	}

//	public List<Product> getAllProduct() {
//		return productRepository.findAll();
//	}

	public void updateProduct(Product product, Integer id) {
		if (productRepository.existsById(product.getProductId())) {
			productRepository.save(product);
		} else {
			throw new RuntimeException("Product not found with given Id");
		}
	}

	public void deleteProduct(Integer id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
		} else {
			throw new RuntimeException("Product not found with given Id");
		}
	}

}
