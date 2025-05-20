package com.longg.service;

import com.longg.common.Storage;

public class EmailService {
	
	// Need to research more how to send email in JAVA
	public void sendEmailLoginSuccessful() {
		System.out.println("Hi " + Storage.currentCustomer.email + " - You have just logged in successfully.");
	}
	
	public void sendEmailCheckOutSuccessful() {
		System.out.println("Hi " + Storage.currentCustomer.email + " - You have paid successfully.");
	}
}
