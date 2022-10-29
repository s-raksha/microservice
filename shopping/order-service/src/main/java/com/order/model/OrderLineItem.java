package com.order.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_line_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sku_code")
	private String skuCode;

	private BigDecimal price;

	private Integer quantity;
	
	@Column(name = "order_id")
	private Long orderId;

}