package com.longg.service;

import java.util.ArrayList;

import com.longg.common.Storage;
import com.longg.dto.Customer;
import com.longg.dto.Log;

// service class -> contain functions 
public class AuthenService {
	
	CustomerService customerService = new CustomerService();
	// login
	public Customer login(String id, String password) {
		ArrayList<Customer> customers = customerService.readCustomerFile();
		for (Customer c : customers) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return c;
			}
		}
		return null;
	}
	
	public void doWhenLoginSuccessful() {
		EmailService emailService = new EmailService();
		switch (Storage.currentShop.id) {
		case 1: {
			emailService.sendEmail();
		}
		case 2: {
			System.out.println("You have logged in successfully.");
		}
		case 3: {
			LogService logService = new LogService();
			ArrayList<Log> logs = logService.addFileToLog();
			Log log = logs.get(Storage.currentLogId++);
			System.out.println("===================");
			System.out.println(log.id + ". " + log.customer.id + " has logged in successfully in " + log.now);
			System.out.println("===================");
			log.id = Storage.currentLogId;
		}
		default: 
			return;
		}
	}
	// logout
}
