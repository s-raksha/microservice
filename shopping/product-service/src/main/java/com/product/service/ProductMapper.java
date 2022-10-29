package com.product.service;

import java.util.List;
import java.util.stream.Collectors;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.model.Product;

public class ProductMapper {

	public Product getProduct(ProductRequest productRequest) {
		return Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).categoryId(productRequest.getCategoryId()).build();
	}

	public ProductResponse getProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName())
				.description(product.getDescription()).price(product.getPrice()).categoryId(product.getCategoryId())
				.build();
	}

	public List<ProductResponse> getProductResponse(List<Product> product) {
		return product.stream().map(this::getProductResponse).collect(Collectors.toList());
	}
}
