package com.nxhu.sistema_ventas.categoryAndProduct.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Long stock;
	
	@Builder.Default
	private boolean active = true;
}
