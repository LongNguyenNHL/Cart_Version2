package com.longg.dto;

public class Customer {

	public String id;
	public String password;
	public String email;
	public String rank;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String password, String email, String rank) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.rank = rank;
	}
}
