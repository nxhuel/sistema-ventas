package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProductCreateRequest {

	@NotBlank(message = "Product name must not be empty or null")
	private String name;
	
	@NotBlank(message = "Product description must not be empty or null")
	private String description;
	
	@NotNull(message = "Product price must not be empty or null")
	@DecimalMin(value = "1", inclusive = true, message = "The price of the product must not be less than $0")
	private BigDecimal price;
	
	@NotNull(message = "Stock must not be null")
	@Min(value = 1, message = "Stock must be at least 1")
	private Long stock;
	
	@NotNull(message = "The product must be associated with a category")
	private Long category;
}
