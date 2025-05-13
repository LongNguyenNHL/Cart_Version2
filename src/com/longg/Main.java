package com.longg;

import java.util.ArrayList;
import java.util.Scanner;

import com.longg.db.Database;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Product;
import com.longg.service.AuthenService;
import com.longg.service.ShoppingCartService;

public class Main {

	static Cart cart;
	static Scanner scan = new Scanner(System.in);
	private static final int VIEW_CART_OPTION_ON_MENU = 0;

	private static ShoppingCartService cartService = new ShoppingCartService();
	private static AuthenService authenService = new AuthenService();

	public static void main(String[] args) {
		
		selectStore();
		
		boolean isLoggedin;

		do {
			isLoggedin = doLogin();
		} while (!isLoggedin);

		do {
			showMenu();

			System.out.print("Enter An Option: ");
			int option = scan.nextInt();
			scan.nextLine();

			if (option == VIEW_CART_OPTION_ON_MENU) {
				cartService.showCart(cart);
			} else {
				doAddProductToCart(option);
			}

		} while (true);
	}

	private static void showMenu() {
		System.out.println("0. View Cart");
		for (int i = 0; i < Database.PRODUCT_DB.size(); i++) {
			System.out.println(
					(i + 1) + ". " + Database.PRODUCT_DB.get(i).name + " : " + Database.PRODUCT_DB.get(i).price);
		}
	}

	private static boolean doLogin() {
		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();

		boolean isLoggedin = authenService.login(userID, userPassword);
		if (isLoggedin) {
			cart = new Cart();
			cart.items = new ArrayList<CartItem>();
		}
		return isLoggedin;
	}

	private static void doAddProductToCart(int productIndex) {
		Product selectedProduct = Database.PRODUCT_DB.get(productIndex - 1);

		System.out.print("Enter quantity : ");
		int quantity = Integer.parseInt(scan.nextLine());

		cartService.addToCart(cart, selectedProduct, quantity);

		System.out.println("Added succesfully.");
	}
	
	private static void selectStore() {
		System.out.println("---------Select Store---------");
		System.out.println("1. Store A");
		System.out.println("2. Store B");
		System.out.println("Enter your selection: ");
		int storeName = scan.nextInt();
		scan.nextLine();
		
		Database.readCustomerFile(storeName);
		Database.readProductFile(storeName);
	}
}
