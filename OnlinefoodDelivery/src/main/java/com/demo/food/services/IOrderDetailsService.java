package com.demo.food.services;

import java.util.List;

import com.demo.food.entity.OrderDetails;
import com.demo.food.exception.OrderDetailsNotFoundException;

public interface IOrderDetailsService {

	OrderDetails addOrder(OrderDetails order);
	OrderDetails updateOrder(int orderId,OrderDetails order);
	OrderDetails deleteOrderById(int orderId) throws OrderDetailsNotFoundException ;
	OrderDetails removeOrder(int orderId);
	OrderDetails viewAllOrders(int customerId,int cartId);
	List<OrderDetails> viewOrder();

}
