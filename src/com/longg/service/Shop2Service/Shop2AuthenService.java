package com.longg.service.Shop2Service;

import com.longg.service.AuthenService;

public class Shop2AuthenService extends AuthenService {

	@Override
	public void doWhenLoginSuccessful() {
		System.out.println("You have logged in successfully.");
	}
}
