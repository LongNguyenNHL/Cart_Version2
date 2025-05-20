package com.longg.service.Shop3Service;

import java.util.ArrayList;

import com.longg.dto.Log;
import com.longg.service.LogService;
import com.longg.service.ShoppingCartService;

public class Shop3ShoppingCartService implements ShoppingCartService{

	@Override
	public void doWhenCheckOutSuccessful() {
		LogService logService = new LogService();
		ArrayList<Log> logs = logService.addCheckoutFileToLog();
		Log log = logs.get(Log.checkoutId);
		System.out.println("===================");
		System.out.println(Log.checkoutId + ". " + log.customer.id + " has paid " + log.cart.total +  " AUD successfully in " + log.now);
		System.out.println("===================");
		Log.checkoutId++;
	}
}
