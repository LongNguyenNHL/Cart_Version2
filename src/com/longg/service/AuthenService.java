package com.longg.service;

import java.util.ArrayList;
import com.longg.dto.Customer;
import com.longg.dto.Shop;

// service class -> contain functions 
public class AuthenService {
	
	CustomerService customerService = new CustomerService();
	// login
	public boolean login(Shop shop, String id, String password) {
		ArrayList<Customer> customers = customerService.readCustomerFile();
		for (Customer c : customers) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return true;
			}
		}
		return false;
	}

	// logout
}
