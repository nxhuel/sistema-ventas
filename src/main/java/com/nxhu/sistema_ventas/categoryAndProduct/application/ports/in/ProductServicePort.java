package com.nxhu.sistema_ventas.categoryAndProduct.application.ports.in;

import java.util.List;
import java.util.Map;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.exception.ProductNotFoundException;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;

public interface ProductServicePort {

	ProductModel saveProduct(ProductModel productModel);
	
	List<ProductModel> findAllByActive();
	
	List<ProductModel> findAllByInactive();
	
	List<ProductModel> findAllByName(String name);
	
	ProductModel findById(Long id) throws ProductNotFoundException;
	
	ProductModel patchProduct(Long id, Map<String, Object> updates) throws ProductNotFoundException;
	
	void softDeleteProductById(Long id)throws ProductNotFoundException; 
}
