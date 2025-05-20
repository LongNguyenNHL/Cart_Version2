package com.longg.dto;

import java.time.LocalDateTime;

public class Log {
	public static int loginId = 0;
	public static int checkoutId = 0;
	public Customer customer;
	public Cart cart;
	public LocalDateTime now;
	
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Log(Customer customer, LocalDateTime now) {
		super();
		this.customer = customer;
		this.now = now;
	}
	
	public Log(Customer customer, Cart cart, LocalDateTime now) {
		super();
		this.customer = customer;
		this.cart = cart;
		this.now = now;
	}
}
