package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response;

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
public class CategoryProductResponse {

	private String name;
	private String description;
	@Builder.Default
	private List<ProductResponse> products = new ArrayList<>();
}
