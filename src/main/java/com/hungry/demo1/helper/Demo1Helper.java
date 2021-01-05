package com.hungry.demo1.helper;

import java.util.Objects;
import java.util.Random;

/**
 * Contains static/helper methods for the application.
 * 
 * @author dalyan
 * @date 11/13/2020
 */
public final class Demo1Helper {
	
	private static Random numGenerator;
	
	private Demo1Helper() {
		// not called
	}
	
	public static int getRandomInt(int maxVal) {
		if (Objects.isNull(numGenerator)) {
			numGenerator = new Random(System.currentTimeMillis());
		}
		return numGenerator.nextInt(maxVal);
	}
}