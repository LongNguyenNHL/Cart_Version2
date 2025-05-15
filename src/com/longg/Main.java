package com.longg;

import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Product;
import com.longg.dto.Shop;
import com.longg.service.AuthenService;
import com.longg.service.ProductService;
import com.longg.service.ShopService;
import com.longg.service.ShoppingCartService;

public class Main {

	static Cart cart;
	static Shop selectedShop;
	static Scanner scan = new Scanner(System.in);
	private static final int VIEW_CART_OPTION_ON_MENU = 0;

	private static ShoppingCartService cartService = new ShoppingCartService();
	private static AuthenService authenService = new AuthenService();

	public static void main(String[] args) {
		
		selectedShop = selectShop();
		Storage.currentShop = selectedShop;

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
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.readProductFile();
		System.out.println("0. View Cart");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(
					(i + 1) + ". " + products.get(i).name + " : " + products.get(i).price);
		}
	}

	private static boolean doLogin() {

		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();

		boolean isLoggedin = authenService.login(selectedShop, userID, userPassword);
		if (isLoggedin) {
			cart = new Cart();
			cart.items = new ArrayList<CartItem>();
		}
		return isLoggedin;
	}

	private static void doAddProductToCart(int productIndex) {
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.readProductFile();
		Product selectedProduct = products.get(productIndex - 1);

		System.out.print("Enter quantity : ");
		int quantity = Integer.parseInt(scan.nextLine());

		cartService.addToCart(cart, selectedProduct, quantity);

		System.out.println("Added succesfully.");
	}
	
	private static Shop selectShop() {
		ShopService shopService = new ShopService();
		ArrayList<Shop> shops = shopService.getAllShop();
		
		System.out.println("---------Select Store---------");
		for (int i = 0; i < shops.size(); i++) {
			System.out.println(i + 1 + ". " + shops.get(i).name);
		}
		System.out.println("Enter your selection: ");
		int option = scan.nextInt();
		scan.nextLine();
		System.out.println("------------WELCOME TO " + shops.get(option - 1).name + "------------");
		
		return shops.get(option - 1);
	}
}
