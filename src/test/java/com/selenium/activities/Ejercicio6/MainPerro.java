package com.selenium.activities.Ejercicio6;

public class MainPerro {
	
	public static void main(String[] args) {
		Perro perro1 = new Perro();
		Perro perro2 = new Perro();
		Perro[] Perros = {perro1,perro2}; 
		
		perro1.raza = "Chihuahua";
		perro1.sexo = "Macho";
		perro1.tama�o = "Mini";
		
		perro2.raza = "Pastor Aleman";
		perro2.sexo = "Hembra";
		perro2.tama�o = "Grande";
		
		
		for(Perro p: Perros) {
			System.out.println("La raza del perro es: " + p.raza);
			System.out.println("El sexo del perro es: " + p.sexo);
			System.out.println("El tama�o del perro es: " + p.tama�o);
			System.out.println("------------------------------------");
		}
	}
}
