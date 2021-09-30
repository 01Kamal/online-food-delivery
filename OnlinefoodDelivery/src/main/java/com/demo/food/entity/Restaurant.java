package com.demo.food.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restaurantId")
	private int restaurantId;
	@Column(name = "restaurantName")
	private String restaurantName;
	@Column(name = "managerName")
	private String managerName;
	@Column(name = "contactNumber")
	private String contactNumber;
	 
	@JsonIgnore
	@OneToMany(targetEntity = Item.class, mappedBy = "restaurant")
	private List<Item> item = new ArrayList<>();

	public Restaurant() {}
	public Restaurant(int restaurantId, String restaurantName, String managerName, String contactNumber) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}




	public int getRestaurantId() {
		return restaurantId;
	}




	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}




	public String getRestaurantName() {
		return restaurantName;
	}




	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}




	public String getManagerName() {
		return managerName;
	}




	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}




	public String getContactNumber() {
		return contactNumber;
	}




	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}




	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + "]";
	}
	
	
	
}
