package com.nxhu.sistema_ventas.categoryAndProduct.application.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.in.CategoryServicePort;
import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.out.CategoryPersistencePort;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.exception.CategoryNotFoundException;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryServicePort {

	private final CategoryPersistencePort categoryPersistencePort;

	@Override
	public CategoryModel saveCategory(CategoryModel category) {
		return categoryPersistencePort.saveCategory(category);
	}

	@Override
	public List<CategoryModel> findAllActiveCategories() {
		return categoryPersistencePort.findAllActiveCategories();
	}

	@Override
	public List<CategoryModel> findAllInactiveCategories() {
		return categoryPersistencePort.findAllInactiveCategories();
	}

	@Override
	public CategoryModel findById(Long id) throws CategoryNotFoundException {
		return categoryPersistencePort.findCategoryById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " not found"));
	}

	@Override
	public CategoryModel patchCategory(Long id, Map<String, Object> updates) throws CategoryNotFoundException {
		CategoryModel category = categoryPersistencePort.findCategoryById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " not found"));
		
		updates.forEach((key, value) -> {
			switch (key) {
			case "name" -> category.setName((String) value);
			case "description" -> category.setDescription((String) value);
			case "active" -> category.setActive((boolean) value);
			}
		});

		return categoryPersistencePort.saveCategory(category);
	}

	@Override
	public void softDeleteCategoryById(Long id) throws CategoryNotFoundException {
		CategoryModel category = categoryPersistencePort.findCategoryById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " not found"));
		
		category.setActive(false);
		categoryPersistencePort.saveCategory(category);
	}
}
