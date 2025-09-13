package com.nxhu.sistema_ventas.categoryAndProduct.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;

public interface CategoryPersistencePort {

	CategoryModel saveCategory(CategoryModel category);
	
    List<CategoryModel> findAllActiveCategories();
    
    List<CategoryModel> findAllInactiveCategories();
	
	Optional<CategoryModel> findCategoryById(Long id);
}
