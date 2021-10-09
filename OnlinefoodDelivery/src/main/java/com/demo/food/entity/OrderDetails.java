package com.demo.food.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="OrderDetails")
public class OrderDetails {

	@Id
	private int orderId;
	private LocalDateTime orderDate;
	private String orderStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "Cart_Order")
	private FoodCart cart;
	
	
}
