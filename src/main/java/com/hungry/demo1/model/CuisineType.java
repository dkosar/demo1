package com.hungry.demo1.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.hungry.demo1.helper.Demo1Helper;

public enum CuisineType {
	
	AMERICAN("american"),
	CHINESE("chinese"),
	ITALIAN("italian"),
	PAN_ASIAN("pan-asian"),
	JAPANESE("japanese"),
	THAI("thai"),
	ETHIOPIAN("ethiopian"),
	GERMAN("german"),
	TURKISH("turkish"),
	FRENCH("french"),
	INDIAN("indian"),
	VIETNAMESE("vietnamese"),
	GREEK("greek"),
	MIDDLE_EASTERN("middle-eastern"),
	VEGETARIAN("vegetarian"),
	VEGAN("vegan"),
	MEXICAN("mexican"),
	UNKNOWN("unknown");

	private final String description;
	private static List<CuisineType> randomSet;
	
	private CuisineType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public static CuisineType fromDescription(String description) {
		if (StringUtils.isNotEmpty(description)) {
			for (CuisineType ct : values()) {
				if (description.equals(ct.description)) {
					return ct;
				}
			}
		}
		System.err.println("Error deserializing cuisine type from given value: " + description);
		return CuisineType.UNKNOWN;
	}
	
	public static CuisineType getRandom() {
		return randomSet.get(Demo1Helper.getRandomInt(randomSet.size()));
	}
	
	static {
		randomSet = new ArrayList<>();
		for (CuisineType ct : values()) {
			randomSet.add(ct);
		}
	}
}
