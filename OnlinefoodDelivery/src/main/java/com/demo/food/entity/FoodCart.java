package com.demo.food.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="FoodCart")
public class FoodCart {
	
	@Id
	@GeneratedValue
	private int cartId;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,mappedBy="foodcart")
    private Customer customer;
	
	
	@OneToMany(targetEntity=Item.class, cascade=CascadeType.ALL)
	@JoinColumn(name="Cart_Item", referencedColumnName = "cartId")
	private List<Item> Items= new ArrayList<>();
	

}
