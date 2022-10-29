package com.product.service;

import java.util.List;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;

public interface ProductService {
	public ProductResponse save(ProductRequest productRequest);

	public ProductResponse update(Integer productId,ProductRequest productRequest);

	public ProductResponse read(Integer productId);

	public List<ProductResponse> list();

	public void delete(Integer productId);
}
