package com.modelo;

import java.util.Random;

public class Atleta extends Thread {
	// Atributos:
	private byte dorsal;
	private byte segundos;

	// Constructores:
	public Atleta() {
	}

	public Atleta(byte dors) {
		this.dorsal = dors;
	}

	// Métodos:
	public byte getDorsal() {
		return dorsal;
	}// Fin Función

	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}// Fin Procedimiento

	public byte getSegundos() {
		return segundos;
	}// Fin Función

	public void setSegundos(byte segundos) {
		this.segundos = segundos;
	}// Fin Procedimiento

	private void generaSegundos() {
		Random aleatorio = new Random();
		int temp = aleatorio.nextInt(10) + 1;
		while (temp < 9) {
			temp = aleatorio.nextInt(10) + 1;
		} // Fin Mientras

		this.segundos = (byte) temp;
	}// Fin Procedimiento

	@SuppressWarnings("deprecation")
	public void notifica() {
		stop();
		System.out.println(this.dorsal + " llega.");
	}

	@Override
	public void run() {
		generaSegundos();
		Thread.yield();
	}// Fin Procedimiento

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		stop();
		return "\n" + "Dorsal: " + this.dorsal + "\tSegundos: " + this.segundos;
	}// Fin Función

}
