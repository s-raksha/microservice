package com.inventry.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.model.Inventry;

public interface InventryRepository extends JpaRepository<Inventry, Long>{

	public Optional<Inventry> findBySkuCode(String skuCode);
}
