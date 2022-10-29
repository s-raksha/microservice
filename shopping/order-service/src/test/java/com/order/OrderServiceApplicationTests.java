package com.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.model.Order;
import com.order.model.OrderLineItem;
import com.order.repository.OrderRepository;

@SpringBootTest
class OrderServiceApplicationTests {
	@Autowired
	private OrderRepository orderRepository;

	@Test
	void contextLoads() {
		List<OrderLineItem> orders = new ArrayList<>();
		orders.add(OrderLineItem.builder().skuCode("123456").price(BigDecimal.valueOf(13.34)).quantity(1).build());
		orderRepository.save(Order.builder().orderNumber(UUID.randomUUID().toString()).orderLineitems(orders).build());
	}

}
