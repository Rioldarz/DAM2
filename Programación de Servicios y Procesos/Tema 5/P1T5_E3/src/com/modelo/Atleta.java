package com.modelo;

public class Atleta extends Thread{
	// Atributos:
	private String nombre;
	private byte dorsal;

	// Constructores:
	public Atleta(String nombre, byte dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
	}// Fin Constructor

	// Métodos:
	public String getNombre() {
		return nombre;
	}// Fin Función

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// Fin Procedimiento

	public byte getDorsal() {
		return dorsal;
	}// Fin Función

	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}// Fin Procedimiento

}
