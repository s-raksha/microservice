package com.order.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@Column(name = "order_number")
	private String orderNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderLineItem> orderLineitems;

}
