package com.vegibazar.dao.api;

import java.util.List;

import com.vegibazar.dao.entity.Order;

public interface OrderAPI {

	public boolean saveOrder(Order order);
	
	public boolean cancelOrder(int uId);
	
	public List<Order> getAllOrder();
	
	public List<Order> getAllOrderByEmail(int uId);
	
	
	
}
