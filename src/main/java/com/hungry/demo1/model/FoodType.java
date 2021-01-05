package com.hungry.demo1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.hungry.demo1.helper.Demo1Helper;

public enum FoodType {
	
	BURGERS("burgers"),
	FRIES("fries"),
	PIZZA("pizza"),
	RAMEN("ramen"),
	DUMPLINGS("dumplings"),
	ICE_CREAM("ice cream"),
	CHEESESTEAKS("cheesesteaks"),
	BURRITOS("burritos"),
	SUSHI("sushi"),
	TACOS("tacos"),
	FROZEN_YOGURT("frozen yogurt"),
	QUESADILLAS("quesadillas"),
	BAO("bao"),
	ACAI_BOWLS("acai bowls"),
	FRIED_CHICKEN("fried chicken"),
	CHICKEN_SANDWICHES("chicken sandwiches"),
	GYROS("gyros"),
	SALADS("salads"),
	PITAS("pitas"),
	PASTA("pasta"),
	HOT_DOGS("hot dogs"),
	MILKSHAKES("milkshakes"),
	NOODLES("noodles"),
	COFFEE("coffee"),
	TEA("tea"),
	SODA("soda"),
	HOT_CHOCOLATE("hot chocolate"),
	FISH("fish"),
	STEAK("steak"),
	KEBABS("kebabs"),
	LOBSTER("lobster"),
	SEAFOOD("seafood"),
	CHICKEN("chicken"),
	SOUP("soup"),
	UNKNOWN("unknown");
	
	
	private final String description;
	private static List<FoodType> randomSet;
	
	private FoodType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public static FoodType fromDescription(String description) {
		if (StringUtils.isNotEmpty(description)) {
			for (FoodType ft : values()) {
				if (description.equals(ft.description)) {
					return ft;
				}
			}
		}
		System.err.println("Error deserializing food type from given value: " + description);
		return FoodType.UNKNOWN;
	}
	
	public static FoodType getRandom() {
		return randomSet.get(Demo1Helper.getRandomInt(randomSet.size()));
	}
	
	static {
		randomSet = new ArrayList<>();
		randomSet.addAll(Arrays.asList(FoodType.values()));
	}

}
