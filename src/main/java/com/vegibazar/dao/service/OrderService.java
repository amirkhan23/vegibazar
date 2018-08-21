package com.vegibazar.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.Order;
import com.vegibazar.dao.impl.OrderApiImpl;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderApiImpl oai;

	public boolean saveOrder(Order order) {
		return oai.saveOrder(order);
	}

	public boolean cancelOrder(int uId) {
		return oai.cancelOrder(uId);

	}

	public List<Order> getAllOrder() {
		return oai.getAllOrder();

	}

	public List<Order> getAllOrderByEmail(int uId) {
		return oai.getAllOrderByEmail(uId);

	}

}
