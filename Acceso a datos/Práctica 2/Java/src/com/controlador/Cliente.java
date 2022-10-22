package com.controlador;

public class Cliente {
	// Atributos:
	private String nombre;
	private int edad;
	private String ciudad;
	private String padre;
	private String madre;

	// Constructor:
	public Cliente() {
	}// Fin Constructor

	public Cliente(String nom, int ed, String ciu, String pad, String mad) {
		this.nombre = nom;
		this.edad = ed;
		this.ciudad = ciu;
		this.padre = pad;
		this.madre = mad;
	}// Fin Constructor

	// Métodos:
	public String getNombre() {
		return nombre;
	}// Fin Función

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// Fin Procedimiento

	public int getEdad() {
		return edad;
	}// Fin Función

	public void setEdad(int edad) {
		this.edad = edad;
	}// Fin Procedimiento

	public String getCiudad() {
		return ciudad;
	}// Fin Función

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}// Fin Procedimiento

	public String getPadre() {
		return padre;
	}// Fin Función

	public void setPadre(String padre) {
		this.padre = padre;
	}// Fin Procedimiento

	public String getMadre() {
		return madre;
	}// Fin Función

	public void setMadre(String madre) {
		this.madre = madre;
	}// Fin Procedimiento

	@Override
	public String toString() {
		return this.nombre + ", " + this.edad + ", " + this.ciudad + ", " + this.padre + ", " + this.madre;
	}// Fin Función

}
