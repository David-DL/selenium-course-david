package com.selenium.activities.Ejercicio1;

public class Ejercicio1 {
	public static void main(String[] args) {
//		1- If
//		2- If else
//		3- If nested
//		4- If else if
//		5- Switch
		
		// Variables
		double velocidad = 29.9; // KM/h
		double limiteVelocidad = 80; // KM/h - Avenida
		boolean isCarretera = false;
		boolean isZonaEscolar = true;
		
		
		
		if(isZonaEscolar) {
			limiteVelocidad = 30;
		} else if(isCarretera) {
			limiteVelocidad = 100;
		}
		
		if(velocidad > limiteVelocidad) {
			System.out.println("Calle - Multa");
		} else {
			System.out.println("Calle - Manejas bien!!");
		}
		
		
		
	
	}

}
