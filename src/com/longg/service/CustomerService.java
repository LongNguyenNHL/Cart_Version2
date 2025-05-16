package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Customer;

public class CustomerService {
	
	public ArrayList<Customer> readCustomerFile() {
		
		try {
			File myFile = new File(Storage.FILE_PATH + Storage.currentShop.shopPath + "/customer.txt");
			Scanner reader = new Scanner(myFile);
			ArrayList<Customer> customers = new ArrayList<Customer>();
			//hasNextLine: kiem tra xem con dong nao chua doc khong
			while (reader.hasNextLine()) {
				String line = reader.nextLine(); // Doc 1 dong trong file
				String[] parts = line.split(","); 
				
				customers.add(new Customer(parts[0],parts[1],parts[2]));
				 
			}
			reader.close();
			return customers;
		} catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
		}
		return null;
	}
}
