package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.request.CategoryCreateRequest;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response.CategoryProductResponse;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response.CategoryResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { ProductRestMapper.class})
public interface CategoryRestMapper {
	
	CategoryModel toCategoryModel(CategoryCreateRequest categoryCreateRequest);
	
	CategoryResponse toCategoryResponse(CategoryModel categoryModel);
		
	List<CategoryResponse> toCategoriesResponses(List<CategoryModel> categoriesModels);
	
	CategoryProductResponse toCategoryProductResponse(CategoryModel categoryModel);
	
}
