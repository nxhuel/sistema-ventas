package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

	ProductEntity toProductEntity(ProductModel productModel);
	
	ProductModel toProductModel(ProductEntity productEntity);
	
	List<ProductModel> toProductModels(List<ProductEntity> productEntities);
}
