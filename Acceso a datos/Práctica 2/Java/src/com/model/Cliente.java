package com.model;

/**
 * @author Miguel Angel Rodriguez Dali
 *
 */
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
	/**
	 * @return String
	 */
	public String getNombre() {
		return this.nombre;
	}// Fin Función

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// Fin Procedimiento

	/**
	 * @return Integer
	 */
	public int getEdad() {
		return this.edad;
	}// Fin Función

	/**
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}// Fin Procedimiento

	/**
	 * @return String
	 */
	public String getCiudad() {
		return this.ciudad;
	}// Fin Función

	/**
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}// Fin Procedimiento

	/**
	 * @return String
	 */
	public String getPadre() {
		return this.padre;
	}// Fin Función

	/**
	 * @param padre
	 */
	public void setPadre(String padre) {
		this.padre = padre;
	}// Fin Procedimiento

	/**
	 * @return String
	 */
	public String getMadre() {
		return this.madre;
	}// Fin Función

	/**
	 * @param madre
	 */
	public void setMadre(String madre) {
		this.madre = madre;
	}// Fin Procedimiento

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return this.nombre + ", " + this.edad + ", " + this.ciudad + ", " + this.padre + ", " + this.madre;
	}// Fin Función

}
