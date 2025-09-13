package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.mapper;

import org.mapstruct.Mapper;

import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductRestMapper {

    ProductResponse toProductResponse(ProductModel productModel);
}
