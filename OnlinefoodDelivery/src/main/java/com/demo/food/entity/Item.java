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

import lombok.ToString;

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

	public Item() {}

	public Item(int itemId, String itemName, int quantity, double cost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.cost = cost;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", cost=" + cost
				+ ", category=" + category + ", restaurant=" + restaurant + "]";
	}

	
	
	

}
