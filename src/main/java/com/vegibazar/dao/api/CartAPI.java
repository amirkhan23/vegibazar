package com.vegibazar.dao.api;

import com.vegibazar.dao.entity.Cart;

public interface CartAPI {

	public boolean addCart(Cart cart);

	public boolean removeCart(Cart cart);

}
