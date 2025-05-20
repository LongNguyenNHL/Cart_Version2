package com.longg.service.Shop3Service;

import java.util.ArrayList;

import com.longg.common.Storage;
import com.longg.dto.Log;
import com.longg.service.AuthenService;
import com.longg.service.LogService;

public class Shop3AuthenService extends AuthenService {

	@Override
	public void doWhenLoginSuccessful() {
		LogService logService = new LogService();
		ArrayList<Log> logs = logService.addLoginFileToLog();
		Log log = logs.get(Log.loginId);
		System.out.println("===================");
		System.out.println(Log.loginId + ". " + log.customer.id + " has logged in successfully in " + log.now);
		System.out.println("===================");
		Log.loginId++;
	}
}
