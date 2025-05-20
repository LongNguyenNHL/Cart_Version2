package com.longg.service;

import java.text.DecimalFormat;

import com.longg.common.Storage;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Product;
import com.longg.service.Shop1Service.Shop1ShoppingCartService;
import com.longg.service.Shop2Service.Shop2ShoppingCartService;
import com.longg.service.Shop3Service.Shop3ShoppingCartService;

public interface ShoppingCartService {

	public default void addToCart(Cart cart, Product product, int quantity) {
		CartItem item = findProduct(cart, product);

		if (item != null) {
			item.quantity += quantity;
			item.totalPrice =  item.price * item.quantity;
		} else {
			item  = new CartItem(product, quantity);
			cart.items.add(item);
			item.totalPrice =  item.price * item.quantity;
		}
	}

	private CartItem findProduct(Cart cart, Product product) {
		for (CartItem item : cart.items) {
			if (item.name.equals(product.name)) {
				return item;
			}
		}
		return null;
	}

	public default void showCart(Cart cart) {
		if (cart.items.size() == 0) {
			System.out.println("Your cart is empty");
			return;
		}
		for (CartItem i : cart.items) {
			System.out.println(i.name + " = " + i.price + ". quantity = " + i.quantity + ". total price = " + i.totalPrice);
		}
	}
	
	public default void checkOut (Cart cart) {
		cart.total  = 0;
		double shippingFee = 0;
		DecimalFormat fmt = new DecimalFormat("0.##");
		if (cart.items.size() == 0) {
			System.out.println("Your checkout is empty");
			return;
		}
		for (int i = 0; i < cart.items.size(); i++) {
			CartItem item = cart.items.get(i);
			cart.total = cart.total + item.totalPrice;
			shippingFee += + item.quantity * 0.3;
//			System.out.println(item.name + " = " + item.price + ". quantity = " + item.quantity + ". total price = " + item.totalPrice);
			System.out.print(i + 1 + ". " + item.name
			+ " - " + item.price + " AUD"
			+ " - " + item.quantity
			+ " - " + item.totalPrice + " AUD");
			System.out.println();
			System.out.println("SHIP: saving 3 - 5 days - " + fmt.format(shippingFee) + " Aud");
			System.out.println();
		}
		
		double discount = 0;
		
//		discount = total * user.getRank().promotion / 100;
//		
//System.out.println("RANK " + user.rank + ": discount " + user.getRank().promotion + "% = " + fmt.format(discount) + " AUD");
//
//total = total + shippingFee - discount ;
//
		System.out.println("TOTAL: " + fmt.format(cart.total) + " AUD");
		doWhenCheckOutSuccessful();
	}
	
	public void doWhenCheckOutSuccessful();
	
	public static ShoppingCartService selectShoppingCartService() {
		if (Storage.currentShop.id == 1) {
			return new Shop1ShoppingCartService();
		} else if (Storage.currentShop.id == 2) {
			return new Shop2ShoppingCartService();
		} else {
			return new Shop3ShoppingCartService();
		}
	}
}
