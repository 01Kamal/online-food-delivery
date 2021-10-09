package com.demo.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.food.entity.OrderDetails;
import com.demo.food.exception.OrderDetailsNotFoundException;
import com.demo.food.services.IOrderDetailsService;

@RestController
public class OrderDetailsController {
	
	@Autowired
	IOrderDetailsService orderService;
	
	//view order
      @GetMapping("/order")
	  ResponseEntity <List<OrderDetails>> viewOrder()
	   {
		  return new ResponseEntity<>(orderService.viewOrder(),HttpStatus.OK);
	  }
      
	//add order
	@PostMapping("/addorder")
	ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order) {
	
		OrderDetails std = orderService.addOrder(order);
		return new ResponseEntity<>(std, HttpStatus.CREATED); // 201 created
	}
	//delete order
	@DeleteMapping("/deleteorder/{orderId}")
    ResponseEntity<OrderDetails> removeOrder(@PathVariable ("orderId")int orderId ) throws OrderDetailsNotFoundException
    {
	  OrderDetails ord =orderService.removeOrder(orderId);
   	   return new ResponseEntity<>(ord,HttpStatus.OK);
     } 
	 
	//update order
	@PutMapping("/order/update/{orderId}")
	ResponseEntity<OrderDetails> updateOrder(@PathVariable("orderId") int orderId , @RequestBody OrderDetails order)
	{
		OrderDetails ord=orderService.updateOrder(orderId,order);
		 return new ResponseEntity<>(ord,HttpStatus.OK);
	}

	//get customer order details
	@GetMapping("/order/{customerId}/cart/{cartId}")
	   ResponseEntity<OrderDetails> viewAllOrders(@PathVariable("customerId") int  customerId,@PathVariable("cartId") int  cartId)
	   {
		OrderDetails order=orderService.viewAllOrders(customerId,cartId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	  }

}
