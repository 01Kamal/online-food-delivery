package com.demo.food.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itemId")
	private int itemId;
	
	@Column(name = "itemName", unique = true, nullable =  false)
	@NotEmpty
	@Size(min=2,message="minimum size should be 2 characters")
	private String itemName;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "cost", nullable = false)
	private double cost;
	
	
	@ManyToOne
	@JoinColumn(name = "category_fk")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_fk")
	private Restaurant restaurant;

}
