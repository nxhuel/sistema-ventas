package com.nxhu.sistema_ventas.categoryAndProduct.domain.model;

import java.util.ArrayList;
import java.util.List;

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
public class CategoryModel {
	private Long id;
	private String name;
	private String description;
	
	@Builder.Default
	private boolean active = true;
	
	@Builder.Default
	private List<ProductModel> products = new ArrayList<>();
}
