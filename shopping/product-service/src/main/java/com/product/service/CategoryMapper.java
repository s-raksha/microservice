package com.product.service;

import java.util.List;
import java.util.stream.Collectors;

import com.product.dto.CategoryRequest;
import com.product.dto.CategoryResponse;
import com.product.model.Category;

public class CategoryMapper {

	public Category getCategory(CategoryRequest categoryRequest) {
		return Category.builder().name(categoryRequest.getName()).description(categoryRequest.getDescription()).build();
	}

	public CategoryResponse getCategoryResponse(Category category) {
		return CategoryResponse.builder().id(category.getId()).name(category.getName())
				.description(category.getDescription()).build();
	}

	public List<CategoryResponse> getCategoryResponse(List<Category> categories) {
		return categories.stream().map(category -> getCategoryResponse(category)).collect(Collectors.toList());
	}

}
