package com.model;

import java.text.SimpleDateFormat;
import java.util.Iterator;

@SuppressWarnings("unused")
public class Videojuego {
	// Atributos:
	private String titulo = null;
	private SimpleDateFormat fecha_lanzamiento = null;
	private String diseniador = null;
	private String modo = null;
	private String plataforma = null;
	private String desarrollador = null;
	private String premio = null;
	private String genero = null;
	private String serie = null;
	private String nominacion = null;
	private String distribuidor = null;
	private float precio = 0;

	// Constructores:
	public Videojuego() {
	}// Por defecto

	public Videojuego(String titulo, SimpleDateFormat fecha, String genero, float precio) {
		this.titulo = titulo;
		this.fecha_lanzamiento = fecha;
		this.genero = genero;
		this.precio = precio;
	}// Básico

	public Videojuego(String titulo, SimpleDateFormat fecha, String diseniador, String modo, String plataforma,
			String desarrollador, String premio, String genero, String serie, String nominacion, String distribuidor,
			float precio) {
		this.titulo = titulo;
		this.fecha_lanzamiento = fecha;
		this.diseniador = diseniador;
		this.modo = modo;
		this.plataforma = plataforma;
		this.desarrollador = desarrollador;
		this.premio = premio;
		this.genero = genero;
		this.serie = serie;
		this.nominacion = nominacion;
		this.distribuidor = distribuidor;
		this.precio = precio;
	}

	// Métodos:
	public String getTitulo() {
		return titulo;
	}// Fin Función

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}// Fin Procedimiento

	public SimpleDateFormat getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}// Fin Función

	public void setFecha_lanzamiento(SimpleDateFormat fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}// Fin Procedimiento

	public String getDiseniador() {
		return diseniador;
	}// Fin Función

	public void setDiseniador(String diseniador) {
		this.diseniador = diseniador;
	}// Fin Procedimiento

	public String getModo() {
		return modo;
	}// Fin Función

	public void setModo(String modo) {
		this.modo = modo;
	}// Fin Procedimiento

	public String getPlataforma() {
		return plataforma;
	}// Fin Función

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}// Fin Procedimiento

	public String getDesarrollador() {
		return desarrollador;
	}// Fin Función

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}// Fin Procedimiento

	public String getPremio() {
		return premio;
	}// Fin Función

	public void setPremio(String premio) {
		this.premio = premio;
	}// Fin Procedimiento

	public String getGenero() {
		return genero;
	}// Fin Función

	public void setGenero(String genero) {
		this.genero = genero;
	}// Fin Procedimiento

	public String getSerie() {
		return serie;
	}// Fin Función

	public void setSerie(String serie) {
		this.serie = serie;
	}// Fin Procedimiento

	public String getNominacion() {
		return nominacion;
	}// Fin Función

	public void setNominacion(String nominacion) {
		this.nominacion = nominacion;
	}// Fin Procedimiento

	public String getDistribuidor() {
		return distribuidor;
	}// Fin Función

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}// Fin Procedimiento

	public float getPrecio() {
		return precio;
	}// Fin Función

	public void setPrecio(float precio) {
		this.precio = precio;
	}// Fin Procedimiento

	@Override
	public String toString() {
		// Entorno:
		String[] salidas = new String[12];

		// Algoritmo:
		for (byte i = 0; i < salidas.length; i++) {
			switch (i) {
			case 0:
				if (this.titulo == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 1:
				if (this.fecha_lanzamiento == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 2:
				if (this.diseniador == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 3:
				if (this.modo == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 4:
				if (this.plataforma == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 5:
				if (this.desarrollador == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 6:
				if (this.premio == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 7:
				if (this.genero == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 8:
				if (this.serie == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 9:
				if (this.nominacion == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 10:
				if (this.distribuidor == null) {
					salidas[i] = "";
				} // Fin Si
				break;
			case 11:
				if (this.precio == 0) {
					salidas[i] = "";
				} // Fin Si
				break;
			}// Fin Según Sea
		} // Fin Para

		return "Título: " + salidas[0] + "Fecha de lanzamiento: " + salidas[1] + "Diseñador: " + salidas[2] + "Modo: "
				+ salidas[3] + "Plataforma: " + salidas[4] + "Desarrollador: " + salidas[5] + "Premio: " + salidas[6]
				+ "Género: " + salidas[7] + "Serie: " + salidas[8] + "Nominación: " + salidas[9] + "Distribuidor"
				+ salidas[10] + "Precio(€): " + salidas[11];
	}//Fin Función
}
