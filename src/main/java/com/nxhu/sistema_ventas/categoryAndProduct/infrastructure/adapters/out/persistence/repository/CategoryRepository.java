package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.out.persistence.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	List<CategoryEntity> findAllByActiveTrue();
	
	List<CategoryEntity> findAllByActiveFalse();
}
