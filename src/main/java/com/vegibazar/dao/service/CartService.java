package com.vegibazar.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.Cart;
import com.vegibazar.dao.impl.CartApiImpl;

@Service
@Transactional
public class CartService {

	@Autowired
	CartApiImpl cai;

	public boolean addCart(Cart cart) {
		return cai.addCart(cart);

	}

	public boolean removeCart(Cart cart) {
		return cai.removeCart(cart);

	}

}
