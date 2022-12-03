package com.order.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.order.dto.InventoryResponse;
import com.order.dto.OrderRequest;
import com.order.exception.OutOfStockException;
import com.order.model.Order;
import com.order.model.OrderLineItem;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		Order order = getOrder(orderRequest);

		// check if the product is in stock
		List<String> skuCodes = order.getOrderLineitems().stream().map(OrderLineItem::getSkuCode).toList();
		InventoryResponse[] inventoryResponses = webClient.build().get()
				.uri("http://inventory-service/api/inventory/", UriBuilder -> UriBuilder.queryParam("skuCodes", skuCodes).build()).retrieve()
				.bodyToMono(InventoryResponse[].class).block();
		Boolean allproductInStiock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::getIsInStock);
		if(!allproductInStiock)
			throw new OutOfStockException("Product is not in stock, please try again later");
		
		orderRepository.save(order);
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
