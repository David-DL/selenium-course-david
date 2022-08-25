package com.selenium.activities.Ejercicio6;

public class MainNumbers {

	public static void main(String[] args) {
		printValues(10, 16);
		System.out.println("-------------------------------");
		printValues(0, 9);
		System.out.println("-------------------------------");
		printValues(-2, 3);
		System.out.println("-------------------------------");
		printValues(4, -5);
		System.out.println("-------------------------------");
		printValues(9, 2);
		System.out.println("-------------------------------");
		printValues(3, 100);
	}
	
	public static void printValues(int minInterval, int maxInterval) {
		Boolean minIsPositive = minInterval >= 0;
		Boolean maxIsPositive = maxInterval >= 0;
		Boolean maxIsGreaterThanMin = maxInterval >= minInterval;
		
		if(minIsPositive && maxIsPositive && maxIsGreaterThanMin) {
			for(int i = minInterval; i <= maxInterval; i++) {
				System.out.println(i);
			}
		} else {
			if(!minIsPositive) {
				System.out.println("Min is not positive: " + minInterval);
			}
			if(!maxIsPositive) {
				System.out.println("Max is not positive: " + maxInterval);
			}
			if (!maxIsGreaterThanMin) {
				System.out.println("Oops, your max is not greater than min:");
				System.out.println("Max: " + maxInterval);
				System.out.println("Min: " + minInterval);
			}
		}
		

	}

}
