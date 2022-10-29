package com.inventry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.service.InventryService;

@RestController
@RequestMapping("/api/inventry")
public class InventryController {

	@Autowired
	private InventryService inventryService;

	@GetMapping("/{sku-code}")
	public ResponseEntity<Boolean> isInStock(@PathVariable(name = "sku-code") String skuCode) {
		return new ResponseEntity<>(inventryService.isInstock(skuCode), HttpStatus.OK);
	}

}
