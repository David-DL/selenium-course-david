package com.selenium.activities.Ejercicio6;

public class MainPerro {
	
	public static void main(String[] args) {
		Perro perro1 = new Perro();
		Perro perro2 = new Perro();
		Perro[] Perros = {perro1,perro2}; 
		
		perro1.raza = "Chihuahua";
		perro1.sexo = "Macho";
		perro1.tamaño = "Mini";
		
		perro2.raza = "Pastor Aleman";
		perro2.sexo = "Hembra";
		perro2.tamaño = "Grande";
		
		
		for(Perro p: Perros) {
			System.out.println("La raza del perro es: " + p.raza);
			System.out.println("El sexo del perro es: " + p.sexo);
			System.out.println("El tamaño del perro es: " + p.tamaño);
			System.out.println("------------------------------------");
		}
	}
}
