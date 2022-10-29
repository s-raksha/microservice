package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.CategoryRequest;
import com.product.dto.CategoryResponse;
import com.product.exception.ResourceNotFoundException;
import com.product.model.Category;
import com.product.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	private CategoryMapper mapper = new CategoryMapper();

	@Override
	public CategoryResponse save(CategoryRequest categoryRequest) {
		return mapper.getCategoryResponse(categoryRepository.save(mapper.getCategory(categoryRequest)));
	}

	@Override
	public CategoryResponse update(Integer categoryId, CategoryRequest categoryRequest) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", String.valueOf(categoryId)));
		category.setName(categoryRequest.getName());
		category.setDescription(categoryRequest.getDescription());
		return mapper.getCategoryResponse(categoryRepository.save(category));
	}

	@Override
	public CategoryResponse read(Integer categoryId) {
		return mapper.getCategoryResponse(categoryRepository.findById(categoryId).orElseThrow(
				() -> new ResourceNotFoundException("Category", "categoryId", String.valueOf(categoryId))));
	}

	@Override
	public List<CategoryResponse> list() {
		return mapper.getCategoryResponse(categoryRepository.findAll());
	}

	@Override
	public void delete(Integer categoryId) {
		categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", String.valueOf(categoryId)));
		categoryRepository.deleteById(categoryId);

	}

}
