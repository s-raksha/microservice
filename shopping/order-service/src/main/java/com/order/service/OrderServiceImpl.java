package com.order.service;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.OrderRequest;
import com.order.model.Order;
import com.order.model.OrderLineItem;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		orderRepository.save(getOrder(orderRequest));
	}

	private Order getOrder(OrderRequest orderRequest) {
		return Order.builder().orderNumber(UUID.randomUUID().toString())
				.orderLineitems(orderRequest.getOrderLineItemRequest().stream()
						.map(orderLineItem -> OrderLineItem.builder().skuCode(orderLineItem.getSkuCode())
								.price(orderLineItem.getPrice()).quantity(orderLineItem.getQuantity()).build())
						.collect(Collectors.toList()))
				.build();
	}

}
