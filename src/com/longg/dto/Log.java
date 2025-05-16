package com.longg.dto;

import java.time.LocalDateTime;

public class Log {
	public int id = 0;
	public Customer customer;
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
}
