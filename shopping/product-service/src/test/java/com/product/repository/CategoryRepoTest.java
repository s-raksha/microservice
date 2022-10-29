package com.product.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.model.Category;
import com.product.repo.CategoryRepository;
import com.product.repo.ProductRepository;
import com.product.service.CategoryService;
import com.product.service.CategoryServiceImpl;

@SpringBootTest
public class CategoryRepoTest {
	
//	@Autowired
	@InjectMocks
	private CategoryService categoryService = new CategoryServiceImpl();
	
	@Mock
	private CategoryRepository categoryRepository;

//	@Autowired
//	private ProductRepository productRepository;

	@Test
	public void testList() {
//		System.out.println(
//				productRepository.save(Product.builder().name("Samsung").description("32 GB ").categoryId(1).build()));

//		categoryRepository.save(Category.builder().name("cloth").description("clothing").build());
		when(categoryRepository.findAll()).thenReturn(new ArrayList<Category>());
		assertEquals(categoryService.list().size(),2);
	}

}
