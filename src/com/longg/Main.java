package com.longg;

import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Customer;
import com.longg.dto.Product;
import com.longg.dto.Rank;
import com.longg.dto.Shop;
import com.longg.service.AuthenService;
import com.longg.service.ProductService;
import com.longg.service.RankService;
import com.longg.service.ShopService;
import com.longg.service.ShoppingCartService;

public class Main {

	static Cart cart;
	static Shop selectedShop;
	static Customer customer;
	static Rank rank;
	static Scanner scan = new Scanner(System.in);
	private static final int VIEW_CART_OPTION_ON_MENU = 0;
	private static final int CHECK_OUT_OPTION_ON_MENU = 1;
	private static final int VIEW_RANK_OPTION_ON_MENU = 2;
	private static ShoppingCartService cartService = null;
	private static AuthenService authenService = null;
	private static RankService rankService = new RankService();

	public static void main(String[] args) {
		
		selectedShop = selectShop();
		Storage.currentShop = selectedShop;
		
		authenService = AuthenService.selectAuthenService();
		cartService = ShoppingCartService.selectShoppingCartService();
		
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
			} else if (option == CHECK_OUT_OPTION_ON_MENU) {
				Storage.currentCart = cart;
				cartService.checkOut(cart);
				return;
			} else if (option == VIEW_RANK_OPTION_ON_MENU) {
				rankService.showRank();
			} else {
				doAddProductToCart(option);
			}
		} while (true);
	}

	private static void showMenu() {
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.readProductFile();
		System.out.println("0. View Cart");
		System.out.println("1. Check out");
		System.out.println("2. View rank");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(
					(i + 3) + ". " + products.get(i).name + " : " + products.get(i).price);
		}
	}

	private static boolean doLogin() {
	
		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();

		boolean isLoggedin = false;
		customer = authenService.login(userID, userPassword);
		if (customer != null) {
			cart = new Cart();
			cart.items = new ArrayList<CartItem>();
			Storage.currentCustomer = customer;
			authenService.doWhenLoginSuccessful();
			rank = rankService.getRank();
			Storage.currentRank = rank;
			isLoggedin = true;
		}
		return isLoggedin;
	}

	private static void doAddProductToCart(int productIndex) {
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.readProductFile();
		Product selectedProduct = products.get(productIndex - 3);

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
