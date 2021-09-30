package com.demo.food.entity;

import lombok.Data;

@Data
public class ItemErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;

}
