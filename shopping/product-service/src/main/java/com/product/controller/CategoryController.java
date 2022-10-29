package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.CategoryRequest;
import com.product.dto.CategoryResponse;
import com.product.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
		CategoryResponse response = categoryService.save(categoryRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse> readCategory(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(categoryService.read(categoryId));
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryResponse>> listCategories() {
		return ResponseEntity.ok(categoryService.list());
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse> updateCategoriy(@PathVariable Integer categoryId,
			@RequestBody @Valid CategoryRequest categoryRequest) {
		return ResponseEntity.ok(categoryService.update(categoryId, categoryRequest));
	}

	@DeleteMapping("/{categoryId}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCategoriy(@PathVariable Integer categoryId) {
		categoryService.delete(categoryId);
	}

}
