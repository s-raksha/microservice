package com.product.service;

import java.util.List;

import com.product.dto.CategoryRequest;
import com.product.dto.CategoryResponse;

public interface CategoryService {

	public CategoryResponse save(CategoryRequest categoryRequest);

	public CategoryResponse update(Integer categoryId,CategoryRequest categoryRequest);

	public CategoryResponse read(Integer categoryId);

	public List<CategoryResponse> list();

	public void delete(Integer categoryId);

}