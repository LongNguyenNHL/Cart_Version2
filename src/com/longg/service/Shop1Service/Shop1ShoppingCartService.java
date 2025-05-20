package com.longg.service.Shop1Service;

import com.longg.service.EmailService;
import com.longg.service.ShoppingCartService;

public class Shop1ShoppingCartService implements ShoppingCartService {

	@Override
	public void doWhenCheckOutSuccessful() {
		EmailService emailService = new EmailService();
		emailService.sendEmailCheckOutSuccessful();
	}

}
