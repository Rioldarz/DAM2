package com.miguelangel.model;

public class Humano {
	// Atributos;
	private String nombre, apellidos;
	private String fecNac;
	private String lugarNac;
	private String dir, municipio, prov;
	private String telf;

	// Constructores:
	public Humano() {
	}

	public Humano(String nombre, String apellidos, String fecNac, String lugarNac, String dir, String municipio,
			String prov, String telf) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecNac = fecNac;
		this.lugarNac = lugarNac;
		this.dir = dir;
		this.municipio = municipio;
		this.prov = prov;
		this.telf = telf;
	}

	// Métodos:
	public String getNombre() {
		return nombre;
	}// Fin Función

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// Fin Procedimiento

	public String getApellidos() {
		return apellidos;
	}// Fin Función

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}// Fin Procedimiento

	public String getFecNac() {
		return fecNac;
	}// Fin Función

	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}// Fin Procedimiento

	public String getLugarNac() {
		return lugarNac;
	}// Fin Función

	public void setLugarNac(String lugarNac) {
		this.lugarNac = lugarNac;
	}// Fin Procedimiento

	public String getDir() {
		return dir;
	}// Fin Función

	public void setDir(String dir) {
		this.dir = dir;
	}// Fin Procedimiento

	public String getMunicipio() {
		return municipio;
	}// Fin Función

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}// Fin Procedimiento

	public String getProv() {
		return prov;
	}// Fin Función

	public void setProv(String prov) {
		this.prov = prov;
	}// Fin Procedimiento

	public String getTelf() {
		return telf;
	}// Fin Función

	public void setTelf(String telf) {
		this.telf = telf;
	}// Fin Procedimiento

}
