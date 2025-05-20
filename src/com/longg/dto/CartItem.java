package com.longg.dto;

public class CartItem extends Product {

	public int quantity;
	public double totalPrice;

	public CartItem() {
	}

	public CartItem(String name, int price) {
		super(name, price);
	}

	public CartItem(Product product, int quantity) {
		this.name = product.name;
		this.price = product.price;
		this.quantity = quantity;
	}
}
