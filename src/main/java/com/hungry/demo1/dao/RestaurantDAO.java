package com.hungry.demo1.dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Aggregates.sample;

import java.util.Collections;
import com.hungry.demo1.model.RestaurantChoice;
import com.mongodb.client.MongoCollection;

public class RestaurantDAO {
	
	private MongoCollection<RestaurantChoice> mongoCollection;
	
	public RestaurantDAO(MongoCollection<RestaurantChoice> mongoCollection) {
		this.mongoCollection = mongoCollection;
	}
	
	// Create
	public void addRestaurant(RestaurantChoice restaurantChoice) {
		mongoCollection.insertOne(restaurantChoice);
		System.out.println("Successfully added record: " + restaurantChoice.getId());
	}
	
	// Read
	public RestaurantChoice getRestaurant(String fieldName, String value) {
		RestaurantChoice retrievedObject = null;
		switch(fieldName) {
			case "id":
				retrievedObject = mongoCollection.find(eq("_id", value)).first();
				break;
			case "name":
				retrievedObject = mongoCollection.find(eq("restaurantName", value)).first();
				break;
			default:
				System.err.printf("Unable to find search case for fieldName: %s and value: %s%n", fieldName, value);
				break;
		}
		
		return retrievedObject;
	}
	
	public RestaurantChoice getRestaurant() {
		return mongoCollection.aggregate(Collections.singletonList(sample(1))).first();
	}
	
	// Update
	public void updateRestaurant() {
		
	}
	
	// Delete
	public boolean deleteRestaurant() {
		return true;
	}
}