package com.inventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	public List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
