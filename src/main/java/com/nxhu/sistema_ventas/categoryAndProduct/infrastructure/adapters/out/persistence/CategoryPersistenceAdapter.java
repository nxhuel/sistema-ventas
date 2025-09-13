package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.out.CategoryPersistencePort;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.CategoryEntity;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.mapper.CategoryPersistenceMapper;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

	private final CategoryRepository categoryRepository;
	private final CategoryPersistenceMapper mapper;
	
	@Override
	public CategoryModel saveCategory(CategoryModel category) {
		CategoryEntity categoryEntity = mapper.toCategoryEntity(category);
		categoryRepository.save(categoryEntity);
		return mapper.toCategoryModel(categoryEntity);	
	}
	
	@Override
	public List<CategoryModel> findAllActiveCategories() {
		return mapper.toCategoriesModels(categoryRepository.findAllByActiveTrue());
	}
	
	@Override
	public List<CategoryModel> findAllInactiveCategories() {
		return mapper.toCategoriesModels(categoryRepository.findAllByActiveFalse());
	}
	
	@Override
	public Optional<CategoryModel> findCategoryById(Long id) {
		return categoryRepository.findById(id).map(mapper::toCategoryModel);
	}
}
