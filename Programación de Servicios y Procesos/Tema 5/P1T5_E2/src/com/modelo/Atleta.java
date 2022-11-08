package com.modelo;

import java.util.Random;

public class Atleta  extends Thread{
	//Atributos:
	private byte dorsal;
	private byte segundos;
	
	//Constructores:
	public Atleta() {}
	
	public Atleta(byte dors) {
		this.dorsal = dors;
	}
	
	//Métodos:
	public byte getDorsal() {
		return dorsal;
	}//Fin Función

	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}//Fin Procedimiento

	public byte getSegundos() {
		return segundos;
	}//Fin Función

	public void setSegundos(byte segundos) {
		this.segundos = segundos;
	}//Fin Procedimiento
	
	@Override
	public void run() {
		generaSegundos();
		Thread.yield();
	}//Fin Procedimiento
	
	private void generaSegundos() {
		Random aleatorio = new Random();
		this.segundos = (byte) (aleatorio.nextInt(7)+1);
	}//Fin Procedimiento
	
	@SuppressWarnings("deprecation")
	public void notifica() {
		stop();
		System.out.println(this.dorsal + " llega.");
	}
	
	@Override
	public String toString() {
		return "Dorsal: " + this.dorsal + "\nSegundos: " + this.segundos + "\n";
	}//Fin Función
	
}
