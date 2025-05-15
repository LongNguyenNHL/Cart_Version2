package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Customer;
import com.longg.dto.Product;
import com.longg.dto.Shop;

import environment.Environment;

public class ProductService {
	
	public ArrayList<Product> readProductFile() {
			
			try {
				File myFile = new File(Storage.FILE_PATH + Storage.currentShop.shopPath + "/product.txt");
				Scanner reader = new Scanner(myFile);
				ArrayList<Product> products = new ArrayList<Product>();
				//hasNextLine: kiem tra xem con dong nao chua doc khong
				while (reader.hasNextLine()) {
					String line = reader.nextLine(); // Doc 1 dong trong file
					String[] parts = line.split(","); 
					
					products.add(new Product(parts[0],Integer.parseInt(parts[1])));
					 
				}
				reader.close();
				return products;
			} catch (FileNotFoundException e) {
	            System.out.println("File not found.");
	            e.printStackTrace();
			}
			return null;
	}
}
