package com.longg.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.dto.Customer;
import com.longg.dto.Product;

public class Database {

	// constant
	public static final ArrayList<Customer> CUSTOMER_DB = new ArrayList<Customer>();
	public static final ArrayList<Product> PRODUCT_DB = new ArrayList<Product>();
	
	private static final int STORE_A = 1;
	private static final int STORE_B = 2;

	public static void readCustomerFile(int storeName) {
		
		String filePath = getCustomerFilePath(storeName);
		if (filePath == null) {
			System.out.println("Invalid input");
			return;
		}
		
		try {
			File myFile = new File(filePath);
			Scanner reader = new Scanner(myFile);
			
			//hasNextLine: kiem tra xem con dong nao chua doc khong
			while (reader.hasNextLine()) {
				String line = reader.nextLine(); // Doc 1 dong trong file
				String[] parts = line.split(","); 
				
				CUSTOMER_DB.add(new Customer(parts[0],parts[1]));
				 
			}
			reader.close();
		} catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
		}
	}
	
	private static String getCustomerFilePath(int storeName) {
		switch (storeName) {
		case STORE_A: {
			return "src/com/longg/db/shopA/customer.txt";
		}
		case STORE_B: {
			return "src/com/longg/db/shopB/customer.txt";
		}
		default:
			return null;
		}
	}
	
	public static void readProductFile(int storeName) {
		String filePath = getProductFilePath(storeName);
		
		try {
			File myFile = new File(filePath);
			Scanner reader = new Scanner(myFile);
			
			//hasNextLine: kiem tra xem con dong nao chua doc khong
			while (reader.hasNextLine()) {
				String line = reader.nextLine(); // Doc 1 dong trong file
				String[] parts = line.split(",");

				PRODUCT_DB.add(new Product(parts[0],Integer.parseInt(parts[1])));
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
		}
	}
	
	private static String getProductFilePath(int storeName) {
		switch (storeName) {
		case STORE_A: {
			return "src/com/longg/db/shopA/product.txt";
		}
		case STORE_B: {
			return "src/com/longg/db/shopB/product.txt";
		}
		default:
			return null;
		}
	}
}
