package com.selenium.activities.Ejercicio5;

public class Main {

	public static void main(String[] args) {

		Moto moto1 = new Moto("Harley", "Sportster", "883cc Evolution");
		Moto moto2 = new Moto("Ducati", "Streetfighter", "955cc Superquadro");
		
		moto1.imprimirDetalles();
		moto1.acerlerar(20);
		moto1.encender();
		moto1.acerlerar(30);
		
		moto2.imprimirDetalles();
		moto2.apagar();
		moto2.encender();
		moto2.acerlerar(100);
		moto2.apagar();
		
		moto1.encender();
		moto1.acerlerar(135);
		moto1.apagar();
	}

}
