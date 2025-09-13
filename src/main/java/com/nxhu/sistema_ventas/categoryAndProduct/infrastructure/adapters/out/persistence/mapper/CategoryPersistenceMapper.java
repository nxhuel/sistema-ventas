package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryPersistenceMapper {

	CategoryEntity toCategoryEntity(CategoryModel categoryModel);
	
	CategoryModel toCategoryModel(CategoryEntity categoryEntity);
	
	List<CategoryModel> toCategoriesModels(List<CategoryEntity> categoriesEntities);
}
