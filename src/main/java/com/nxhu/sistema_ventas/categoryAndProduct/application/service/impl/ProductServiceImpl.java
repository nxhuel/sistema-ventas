package com.nxhu.sistema_ventas.categoryAndProduct.application.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.in.ProductServicePort;
import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.out.CategoryPersistencePort;
import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.out.ProductPersistencePort;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.exception.ProductNotFoundException;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServicePort {
	
	private final ProductPersistencePort productPersistencePort;
	private final CategoryPersistencePort categoryPersistencePort;

	@Override
	public ProductModel saveProduct(ProductModel productModel) {
		return productPersistencePort.saveProduct(productModel);
	}

	@Override
	public List<ProductModel> findAllByActive() {
		return productPersistencePort.findAllByActive();
	}

	@Override
	public List<ProductModel> findAllByInactive() {
		return productPersistencePort.findAllByInactive();
	}

	@Override
	public List<ProductModel> findAllByName(String name) {
		return productPersistencePort.findAllByName(name);
	}

	@Override
	public ProductModel findById(Long id) throws ProductNotFoundException {
		return productPersistencePort.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
	}

	@Override
	public ProductModel patchProduct(Long id, Map<String, Object> updates) throws ProductNotFoundException {
	    ProductModel product = productPersistencePort.findById(id)
	            .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));

	    updates.forEach((key, value) -> {
	        switch (key) {
	            case "name" -> product.setName((String) value);
	            case "description" -> product.setDescription((String) value);
	            case "price" -> product.setPrice(new BigDecimal(value.toString())); // safe conversion
	            case "stock" -> product.setStock(Long.valueOf(value.toString()));
	            case "categoryId" -> {
	                Long categoryId = Long.valueOf(value.toString());
	                CategoryModel category = categoryPersistencePort.findCategoryById(categoryId)
	                        .orElseThrow(() -> new RuntimeException("Category with ID " + categoryId + " not found"));
	                product.setCategory(category);
	            }
	        }
	    });

	    return productPersistencePort.saveProduct(product);
	}

	@Override
	public void softDeleteProductById(Long id) throws ProductNotFoundException {
		ProductModel product = productPersistencePort.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
		
		product.setActive(false);
		productPersistencePort.saveProduct(product);
	}
}
