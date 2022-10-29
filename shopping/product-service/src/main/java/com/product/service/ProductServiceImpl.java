package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.exception.ResourceNotFoundException;
import com.product.model.Product;
import com.product.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;

	private ProductMapper productMapper = new ProductMapper();

	@Override
	public ProductResponse save(ProductRequest productRequest) {
		return productMapper.getProductResponse(repo.save(productMapper.getProduct(productRequest)));
	}

	@Override
	public ProductResponse update(Integer productId, ProductRequest productRequest) {
		Product prodcut = repo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "productId", String.valueOf(productId)));
		prodcut.setName(productRequest.getName());
		prodcut.setCategoryId(productRequest.getCategoryId());
		prodcut.setDescription(productRequest.getDescription());
		prodcut.setPrice(productRequest.getPrice());
		prodcut.setCategoryId(productRequest.getCategoryId());
		return productMapper.getProductResponse(repo.save(prodcut));
	}

	@Override
	public ProductResponse read(Integer productId) {
		return productMapper.getProductResponse(repo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "productId", String.valueOf(productId))));
	}

	@Override
	public List<ProductResponse> list() {
		return productMapper.getProductResponse(repo.findAll());
	}

	@Override
	public void delete(Integer productId) {
		repo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product", "productId", String.valueOf(productId)));
		repo.deleteById(productId);

	}

}
