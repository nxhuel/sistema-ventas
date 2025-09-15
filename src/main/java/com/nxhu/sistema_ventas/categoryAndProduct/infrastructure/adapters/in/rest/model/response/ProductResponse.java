package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response;

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
public class ProductResponse {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Long stock;
	private boolean active;
}
