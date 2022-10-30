package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.InventoryResponse;
import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<InventoryResponse> isInstock(List<String> skuCode) {
		return getInventoryResponse(inventoryRepository.findBySkuCodeIn(skuCode));
	}

	private List<InventoryResponse> getInventoryResponse(List<Inventory> inventries) {
		return inventries.stream().map(inventry -> InventoryResponse.builder().skuCode(inventry.getSkuCode())
				.isInStock(inventry.getQuantity() > 0).build()).toList();
	}

}