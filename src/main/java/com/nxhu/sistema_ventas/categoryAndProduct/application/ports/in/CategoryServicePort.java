package com.nxhu.sistema_ventas.categoryAndProduct.application.ports.in;

import java.util.List;
import java.util.Map;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.exception.CategoryNotFoundException;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;

public interface CategoryServicePort {

	CategoryModel saveCategory(CategoryModel category);
	
	List<CategoryModel> findAllActiveCategories();
	
	List<CategoryModel> findAllInactiveCategories();
	
	CategoryModel findById(Long id) throws CategoryNotFoundException;
	
	CategoryModel patchCategory(Long id, Map<String, Object> updates) throws CategoryNotFoundException;
	
	void softDeleteCategoryById(Long id) throws CategoryNotFoundException;
}
