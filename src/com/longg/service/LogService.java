package com.longg.service;

import java.util.ArrayList;
import java.time.LocalDateTime;

import com.longg.common.Storage;
import com.longg.dto.Log;

public class LogService {
	public ArrayList<Log> addLoginFileToLog() {
		ArrayList<Log> list = new ArrayList<>();
		Log log = new Log(Storage.currentCustomer,LocalDateTime.now());
		list.add(log);
		return list;
	}
	
	public ArrayList<Log> addCheckoutFileToLog() {
		ArrayList<Log> list = new ArrayList<>();
		Log log = new Log(Storage.currentCustomer,Storage.currentCart, LocalDateTime.now());
		list.add(log);
		return list;
	}
}
