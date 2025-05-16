package com.longg.service;

import com.longg.common.Storage;

public class EmailService {
	public void sendEmail() {
		System.out.println("Hi " + Storage.currentCustomer.email + " - You have just logged in successfully.");
	}
}
