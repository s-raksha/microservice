package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderRequest;
import com.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/")
	public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return new ResponseEntity<String>("order place sucessfully", HttpStatus.CREATED);
	}

}
