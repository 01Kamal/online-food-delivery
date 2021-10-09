package com.demo.food.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="customerId")
	private int customerId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="age")
	private int age;
	@Column(name="mobileNumber")
	private String mobileNumber; 
	@Column(name="caddress")
	private String caddress;
	@Column(name="email")
	private String email;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_fk")
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_fk")
	private FoodCart foodcart;
	
	

}
