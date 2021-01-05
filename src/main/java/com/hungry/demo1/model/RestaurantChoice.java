package com.hungry.demo1.model;

import java.io.Serializable;
import java.util.Set;

import org.bson.types.ObjectId;

/**
 * Contains the data required to fully describe each restaurant including name, price, rating, etc.
 * 
 * <-- Note on price values -->
 * Price will be broken down based on cost per meal:
 * 1 -> Meal for under $5
 * 2 -> Meal for under $10
 * 3 -> Meal for under $15
 * 4 -> Meal for under $20
 * 5 -> Meal for under $30
 * 6 -> Meal for under $50
 * 7 -> Meal for under $75
 * 8 -> Meal for under $100
 * 9 -> Meal for under $150
 * 10-> Meal for anything else... (!!)
 * 
 * @author dalyan
 * @date 11/23/2020
 */
public class RestaurantChoice implements Serializable {

	private static final long serialVersionUID = -1469672423626037207L;
	
	private ObjectId id;
	private CuisineType cuisineType;
	private Set<FoodType> foodTypes;
	private String restaurantName;
	private Integer priceLevel; // lower value, lower price *see note at bottom for price breakdown*
	private Double rating; // lower value, lower quality (1-10)
	private String description;
	private Set<String> tags;
	
	public RestaurantChoice() {
		// empty constructor for serialization
	}

	public ObjectId getId() {
		return id;
	}

	public CuisineType getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}

	public Set<FoodType> getFoodTypes() {
		return foodTypes;
	}

	public void setFoodTypes(Set<FoodType> foodTypes) {
		this.foodTypes = foodTypes;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantChoice other = (RestaurantChoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RestaurantChoice [id=" + id + ", cuisineType=" + cuisineType.getDescription() + ", foodTypes=" + foodTypes 
				+ ", restaurantName=" + restaurantName + ", priceLevel=" + priceLevel + ", rating=" + rating 
				+ ", description=" + description + "]";
	}
}