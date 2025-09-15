package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.request.ProductCreateRequest;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response.ProductResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRestMapper {

	ProductModel toProductModel(ProductCreateRequest productCreateRequest);
	
    default CategoryModel map(Long categoryId) {
        if (categoryId == null) return null;
        return CategoryModel.builder().id(categoryId).build();
    }
	
    ProductResponse toProductResponse(ProductModel productModel);
    
    List<ProductResponse> toProductResponses(List<ProductModel> productModels);
    
}
