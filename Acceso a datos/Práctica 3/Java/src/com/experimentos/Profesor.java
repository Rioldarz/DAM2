package com.experimentos;

import java.io.Serializable;

@Entity
@Table(name="Profesor")
public class Profesor implements Serializable{
	//Atributos:
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name=nombre)
	private String nombre;
	
	@Column(name="ape1")
	private String ape1;
	
	@Column(name="ape2")
	private String ape2;
	
	//Constructores:
	public Profesor() {}

	public Profesor(int id, String nombre, String ape1, String ape2) {
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}
	
	//Métodos:
	public int getId() {
		return id;
	}//Fin Función

	public void setId(int id) {
		this.id = id;
	}//Fin Procedimiento

	public String getNombre() {
		return nombre;
	}//Fin Función

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//Fin Procedimiento

	public String getApe1() {
		return ape1;
	}//Fin Función

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}//Fin Procedimiento

	public String getApe2() {
		return ape2;
	}//Fin Función

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}//Fin Procedimiento
	
	
}
