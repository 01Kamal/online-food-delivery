package com.demo.food.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue
	private int addressId;
	@NotEmpty
	private String street;
	@NotEmpty
	private String city;
	@NotEmpty
	private String country;
	@NotEmpty
	@Size(min=6,message="minimum size should be 6 and valid")
	private String pincode;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
	private Restaurant restaurant;
	
	


}
