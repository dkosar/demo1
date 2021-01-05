package com.hungry.demo1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hungry.demo1.service.Demo1Service;

@RestController
public class RestaurantController {
	
	private Demo1Service demo1Service;
	
	public RestaurantController(Demo1Service demo1Service) {
		this.demo1Service = demo1Service;
	}
	
	@PostMapping("/start")
	@ResponseBody
	public String initiate() {
		return "Success!\n" + demo1Service.pickRestaurantAtRandom() + "\n";
	}
}