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

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest productRequest) {
		return new ResponseEntity<ProductResponse>(productService.save(productRequest), HttpStatus.CREATED);
	}

	@GetMapping("/{prodctId}")
	public ResponseEntity<ProductResponse> read(@PathVariable Integer prodctId) {
		return ResponseEntity.ok(productService.read(prodctId));
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductResponse>> list() {
		return ResponseEntity.ok(productService.list());
	}

	@PutMapping("/{prodctId}")
	public ResponseEntity<ProductResponse> update(@PathVariable Integer prodctId,
			@RequestBody @Valid ProductRequest productRequest) {
		return ResponseEntity.ok(productService.update(prodctId, productRequest));
	}

	@DeleteMapping("/{prodctId}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Integer prodctId) {
		productService.delete(prodctId);
	}

}
