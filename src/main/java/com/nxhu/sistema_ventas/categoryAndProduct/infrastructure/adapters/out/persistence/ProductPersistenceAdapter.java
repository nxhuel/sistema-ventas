package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.out.ProductPersistencePort;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.ProductEntity;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.mapper.ProductPersistenceMapper;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {
	
	private final ProductRepository productRepository;
	private final ProductPersistenceMapper mapper;
	
	@Override
	public ProductModel saveProduct(ProductModel productModel) {
		ProductEntity productEntity = productRepository.save(mapper.toProductEntity(productModel));
		return mapper.toProductModel(productEntity);
	}

	@Override
	public List<ProductModel> findAllByActive() {
		return mapper.toProductModels(productRepository.findAllByActiveTrue());
	}

	@Override
	public List<ProductModel> findAllByInactive() {
		return mapper.toProductModels(productRepository.findAllByActiveFalse());
	}

	@Override
	public List<ProductModel> findAllByName(String name) {
		return mapper.toProductModels(productRepository.findAllByName(name));
	}

	@Override
	public Optional<ProductModel> findById(Long id) {
		return productRepository.findById(id).map(mapper::toProductModel);
	}
}
