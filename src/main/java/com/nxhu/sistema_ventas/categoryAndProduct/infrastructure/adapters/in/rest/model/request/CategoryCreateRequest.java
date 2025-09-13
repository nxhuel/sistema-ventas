package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.request;

import jakarta.validation.constraints.NotBlank;
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
public class CategoryCreateRequest {

	@NotBlank(message = "Category name must not be empty or null")
	private String name;
	
	@NotBlank(message = "Category description must not be empty or null")
	private String description;

}
