package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.in.ProductServicePort;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.ProductModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.mapper.ProductRestMapper;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.request.ProductCreateRequest;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response.ProductResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestAdapter {

	private final ProductServicePort productServicePort;
	private final ProductRestMapper mapper;
	
	@PostMapping("/v1/api")
	public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
		ProductModel productModel = productServicePort.saveProduct(mapper.toProductModel(productCreateRequest));
		ProductResponse productResponse = mapper.toProductResponse(productModel);
		return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api/active")
	public ResponseEntity<List<ProductResponse>> findAllActiveProducts() {
		List<ProductModel> productsModel = productServicePort.findAllByActive();
		List<ProductResponse> productsResponse = mapper.toProductResponses(productsModel);
		return new ResponseEntity<>(productsResponse, HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/inactive")
	public ResponseEntity<List<ProductResponse>> findAllInactiveProducts() {
		List<ProductModel> productsModel = productServicePort.findAllByInactive();
		List<ProductResponse> productsResponse = mapper.toProductResponses(productsModel);
		return new ResponseEntity<>(productsResponse, HttpStatus.OK);
	}
}
