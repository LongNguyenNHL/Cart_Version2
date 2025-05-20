package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.Storage;
import com.longg.dto.Rank;

public class RankService {
	public ArrayList<Rank> readRankFile() {
		
		try {
			File myFile = new File(Storage.FILE_PATH + Storage.currentShop.shopPath + "/rank.txt");
			Scanner reader = new Scanner(myFile);
			ArrayList<Rank> ranks = new ArrayList<Rank>();
			reader.nextLine();
			//hasNextLine: kiem tra xem con dong nao chua doc khong
			while (reader.hasNextLine()) {
				String line = reader.nextLine(); // Doc 1 dong trong file
				String[] parts = line.split(","); 
				
				ranks.add(new Rank(parts[0],Integer.parseInt(parts[1])));
				 
			}
			reader.close();
			return ranks;
		} catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
		}
		return null;
	}
	
	public Rank getRank() {
		ArrayList<Rank> ranks = readRankFile();
		for (Rank rank : ranks) {
			if (Storage.currentCustomer.rank.equals(rank.name)) {
				return rank;
			}
		}
		return null;
	}
	
	public void showRank() {
		System.out.println("-------------YOUR RANK-------------");
		ArrayList<Rank> ranks = readRankFile();
		for (Rank rank : ranks) {
			if (Storage.currentCustomer.rank.equals(rank.name)) {
				System.out.println("Your rank is " + Storage.currentCustomer.rank + " and you get " + rank.promotion + "% off your total bill");
				return;
			}
		}
	}
}
