package com.longg.service;

import java.util.ArrayList;

import com.longg.common.Storage;
import com.longg.dto.Customer;
import com.longg.service.Shop1Service.Shop1AuthenService;
import com.longg.service.Shop2Service.Shop2AuthenService;
import com.longg.service.Shop3Service.Shop3AuthenService;

// service class -> contain functions 
public abstract class AuthenService {
	
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
	
	public abstract void doWhenLoginSuccessful();
	
	public static AuthenService selectAuthenService() {
		if (Storage.currentShop.id == 1) {
			return new Shop1AuthenService();
		} else if (Storage.currentShop.id == 2) {
			return new Shop2AuthenService();
		} else {
			return new Shop3AuthenService();
		}
	}
	

	// logout
}
