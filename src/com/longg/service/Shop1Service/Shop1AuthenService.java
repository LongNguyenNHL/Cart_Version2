package com.longg.service.Shop1Service;

import com.longg.service.AuthenService;
import com.longg.service.EmailService;

public class Shop1AuthenService extends AuthenService {

	@Override
	public void doWhenLoginSuccessful() {
		EmailService emailService = new EmailService();
		emailService.sendEmailLoginSuccessful();
	}

}
