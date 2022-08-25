package com.selenium.activities.Ejercicio5;

public class Moto {
	
	private String marca;
	private String modelo;
	private String motor;
	private boolean encendida = false;
	private int rpm = 0;
	private int velocidad = 0;
	
	public Moto(String marca, String modelo, String motor) {
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
	}
	
	public Moto(String marca, String motor) {
		this.marca = marca;
		this.motor = motor;
	}
	
	private void imprimirTablero() {
		System.out.println(" ");
		System.out.println("-----------------------------");
		System.out.println(marca + " " + modelo);
		System.out.println(encendida ? "--Encendido--" : "--Apagado--");
		System.out.print("Velocidad: " + velocidad + " km/h  --  ");
		System.out.println("Revoluciones: " + rpm + " RPM");
		System.out.println("-----------------------------");
		System.out.println(" ");
	}
	
	
	public void encender() {
		if(!encendida) {
			encendida = true;
			System.out.println("Encendiendo...");
			System.out.println("Prrrummmm");
			System.out.println("¡Tu moto " + marca + " esta encendida!");
			rpm = 1000;
			imprimirTablero();
		} else {
			System.out.println("Encendiendo...");
			System.out.println("¡La moto ya esta encendida!");
		}
	}
	
	public void acerlerar(int velocidadObj) {
		if(encendida) {
			System.out.println("¡Acelerando!");
			
			if(rpm < 5000) {
				rpm = rpm + 1000;
			}
			
			while(velocidad < velocidadObj) {
				velocidad ++;
				System.out.println("Velocidad: " + velocidad + " km/h");
			}
			imprimirTablero();
		}
		System.out.println("La moto esta apagada :(");
		imprimirTablero();
	}
	
	public void apagar() {
		if(encendida) {
			encendida = false;
			System.out.println("Apagando...");
			rpm = 0;
			imprimirTablero();
			
			System.out.println("Desacelerando...");
			while(velocidad > 0) {
				System.out.println("Velocidad: " + velocidad + " km/h");
				velocidad --;
			}		
			imprimirTablero();
		} else {
			System.out.println("Apagando...");
			System.out.println("¡La moto ya esta apagada!");
		}
	}
	
	public void imprimirDetalles() {
		System.out.println("Tu moto es una " + marca + " " + modelo + " con motor " + motor);
	}
	
	
}
