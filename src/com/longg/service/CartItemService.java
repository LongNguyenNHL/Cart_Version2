package com.longg.service;

import com.longg.dto.CartItem;

public class CartItemService {
	
	CartItem cartItem = new CartItem();
	
	public void calculatePrice() {
		cartItem.totalPrice = cartItem.price * cartItem.quantity;
	}
}
