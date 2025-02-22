package com.controller;

import com.service.PanCardService;
import com.serviceimpl.PanCardServiceImpl;

public class HomeController {
	
	public static void main(String[] args) {
		PanCardService service = new PanCardServiceImpl();
		
//		service.registration();
		
		service.registerSaveOrupdate();
	}

}
