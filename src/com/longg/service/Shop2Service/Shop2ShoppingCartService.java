package com.longg.service.Shop2Service;

import com.longg.service.ShoppingCartService;

public class Shop2ShoppingCartService implements ShoppingCartService {

	@Override
	public void doWhenCheckOutSuccessful() {
		System.out.println("------------You have paid successfully------------");
	}

}
