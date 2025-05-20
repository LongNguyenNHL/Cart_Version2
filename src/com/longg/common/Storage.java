package com.longg.common;

import com.longg.dto.Cart;
import com.longg.dto.Customer;
import com.longg.dto.Rank;
import com.longg.dto.Shop;

public class Storage {
	public static Shop currentShop = null;
	
	public static Customer currentCustomer = null;
	
	public static Cart currentCart = null;
	
	public static Rank currentRank = null;
	
	public static int currentLogId = 0;
	
	public static final String FILE_PATH = "src/com/longg/db/"; 
}
