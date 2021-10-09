package com.demo.food.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.food.dao.ICustomerDao;
import com.demo.food.dao.IFoodCartDao;
import com.demo.food.dao.IOrderDetailsDao;
import com.demo.food.entity.Customer;
import com.demo.food.entity.FoodCart;
import com.demo.food.entity.OrderDetails;
import com.demo.food.exception.OrderDetailsFoundException;
import com.demo.food.exception.OrderDetailsNotFoundException;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {

	@Autowired
	IOrderDetailsDao orderDao;
	
	@Autowired
	IFoodCartDao  cartDao;
	
	@Autowired
	ICustomerDao  customerDao;
	
	@Override
	public List<OrderDetails> viewOrder()
     {
		return orderDao.findAll();
     }
    
	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderDetailsFoundException{
    Optional<OrderDetails> ord= orderDao.findById(order.getOrderId());
    if(ord.isPresent()) {
       throw new OrderDetailsFoundException("order already exists with given id "+ order.getOrderId());
    }
    return orderDao.save(order);
	}

	@Override
	public OrderDetails updateOrder(int orderId,OrderDetails order) 
	{
		OrderDetails ord= orderDao.getById(orderId);
		ord.setOrderDate(order.getOrderDate());
		ord.setOrderStatus(order.getOrderStatus());
		return orderDao. save(ord);
	}

	@Override
	public OrderDetails removeOrder(int orderId) throws OrderDetailsNotFoundException{
	Optional<OrderDetails>  ord= orderDao.findById(orderId);
	if(!ord.isPresent()) {
     throw new OrderDetailsNotFoundException("orderid not exists "+ orderId); 
	 }

	 orderDao.deleteById(orderId);
	 return null;
	}

	@Override
	public OrderDetails deleteOrderById(int orderId) {
	
		return null;
	}
	
	/*@Override
	public OrderDetails viewAllOrders(int customerId) {	
	 Customer customer=customerDao.findById(customerId).get();
	 FoodCart cart=cartDao.findById(customer.getCustomerId()).get();
	 OrderDetails order=orderDao.findById(cart.getCartId()).get();
	 return order;
	}
*/
	  @Override
	  public OrderDetails viewAllOrders(int customerId, int cartId) {
	  Customer customer=customerDao.findById(customerId).get();
	  FoodCart cart=cartDao.findById(cartId).get();
	  OrderDetails order=orderDao.getById(cartId);
      return order;
	}

}
