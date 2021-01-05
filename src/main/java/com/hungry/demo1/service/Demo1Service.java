package com.hungry.demo1.service;

import org.springframework.stereotype.Service;

import com.hungry.demo1.dao.RestaurantDAO;

@Service
public class Demo1Service {
	
	private RestaurantDAO restaurantDao;
	
	public Demo1Service(RestaurantDAO restaurantDao) {
		this.restaurantDao = restaurantDao;
	}
	
	public String pickRestaurantAtRandom() {
		return restaurantDao.getRestaurant().getRestaurantName();
	}
}