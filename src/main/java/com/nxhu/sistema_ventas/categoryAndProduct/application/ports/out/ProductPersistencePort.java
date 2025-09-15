package com.nxhu.sistema_ventas.categoryAndProduct.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;

public interface ProductPersistencePort {

	ProductModel saveProduct(ProductModel productModel);
	
	List<ProductModel> findAllByActive();
	
	List<ProductModel> findAllByInactive();
	
	List<ProductModel> findAllByName(String name);
	
	Optional<ProductModel> findById(Long id);

}
