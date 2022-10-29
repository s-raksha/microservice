package com.inventry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.repository.InventryRepository;

@Service
public class InventryServiceImpl implements InventryService {

	@Autowired
	private InventryRepository inventryRepository;

	@Override
	public boolean isInstock(String skuCode) {
		return inventryRepository.findBySkuCode(skuCode).isPresent();
	}

}