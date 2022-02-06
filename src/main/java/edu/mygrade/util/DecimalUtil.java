package edu.mygrade.util;

public class DecimalUtil {

	public static double round(double value, int point) {
		final double roundPow = Math.pow(10.0, point);
		return Math.round(value * roundPow) / roundPow;
	}

}
