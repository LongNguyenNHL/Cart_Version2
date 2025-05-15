package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.dto.Shop;

public class ShopService {
	
	private final String SHOP_FILE_PATH = "src/com/longg/db/shop/shop.txt";
	
	public ArrayList<Shop> getAllShop() {
		try {
			File myFile = new File(SHOP_FILE_PATH);
			Scanner reader = new Scanner(myFile);
			ArrayList<Shop> shopList = new ArrayList<>();
			reader.nextLine();
			
			//hasNextLine: kiem tra xem con dong nao chua doc khong
			while (reader.hasNextLine()) {
				String line = reader.nextLine(); // Doc 1 dong trong file
				String[] parts = line.split(","); 
				
				shopList.add(new Shop(Integer.parseInt(parts[0]),parts[1],parts[2]));
				 
			}
			reader.close();
			return shopList;
		} catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
		}
		return null;
	}
}
