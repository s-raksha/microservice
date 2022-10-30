package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.InventoryResponse;
import com.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/")
	public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam List<String> skuCodes) {
		return new ResponseEntity<List<InventoryResponse>>(inventoryService.isInstock(skuCodes), HttpStatus.OK);
	}

}
