package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	List<ProductEntity> findAllByActiveTrue();
	
	List<ProductEntity> findAllByActiveFalse();
	
	List<ProductEntity> findAllByName(String name);
}
