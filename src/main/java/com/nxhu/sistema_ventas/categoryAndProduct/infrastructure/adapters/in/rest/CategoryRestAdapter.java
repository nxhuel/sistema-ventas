package com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.sistema_ventas.categoryAndProduct.application.ports.in.CategoryServicePort;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.exception.CategoryNotFoundException;
import com.nxhu.sistema_ventas.categoryAndProduct.domain.model.CategoryModel;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.mapper.CategoryRestMapper;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.request.CategoryCreateRequest;
import com.nxhu.sistema_ventas.categoryAndProduct.infrastructure.adapters.in.rest.model.response.CategoryResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestAdapter {

	private final CategoryServicePort categoryServicePort;
	private final CategoryRestMapper mapper;
	
	@PostMapping("/v1/api")
	public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
		CategoryModel categoryModel = categoryServicePort.saveCategory(mapper.toCategoryModel(categoryCreateRequest));
		CategoryResponse categoryResponse = mapper.toCategoryResponse(categoryModel);
		return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api/active")
	public ResponseEntity<List<CategoryResponse>> findAllActiveCategories() {	
		List<CategoryModel> categoryModels = categoryServicePort.findAllActiveCategories();
		List<CategoryResponse> categoryResponses = mapper.toCategoriesResponses(categoryModels);
		return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/inactive")
	public ResponseEntity<List<CategoryResponse>> findAllInactiveCategories() {	
		List<CategoryModel> categoryModels = categoryServicePort.findAllInactiveCategories();
		List<CategoryResponse> categoryResponses = mapper.toCategoriesResponses(categoryModels);
		return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/{id}")
	public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long id) throws CategoryNotFoundException {
		CategoryResponse categoryResponse = mapper.toCategoryResponse(categoryServicePort.findById(id));
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
	}
	
	@PatchMapping("/v1/api/{id}")
	public ResponseEntity<CategoryResponse> patchCategory(
			@PathVariable Long id, @RequestBody Map<String, Object> updates) throws CategoryNotFoundException {
		CategoryModel categoryModel = categoryServicePort.patchCategory(id, updates);
		CategoryResponse categoryResponse = mapper.toCategoryResponse(categoryModel);
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/{id}")
	public ResponseEntity<String> softDeleteCategoryById(@PathVariable Long id) throws CategoryNotFoundException {
		categoryServicePort.softDeleteCategoryById(id);
		return new ResponseEntity<>("Category successfuly deleted", HttpStatus.NO_CONTENT);
	}
}
