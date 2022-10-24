package com.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccesoProperties {
	// Atributos:
	File ruta;
	String ip = "192.168.9.130:3306";
	String usuario = "user";
	String contrasenia = "test";
	String url = "jdbc:mysql://" + ip + "/myDb";

	// Constructor:
	public AccesoProperties() {
		this.ruta = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Properties");
		this.ruta.mkdir();
		if (!asignarProperties()) {
			crearPropertiesDefault();
		} // Fin Si
	}// Fin Constructor

	// Métodos:
	/**
	 * @return boolean Crea los properties por defecto
	 */
	public boolean crearPropertiesDefault() {
		// Entorno:
		boolean retornar;
		FileWriter ficheroAGenerar;
		String datosAGuardar;

		// Algoritmo:
		retornar = true;

		try {
			ficheroAGenerar = new FileWriter(this.ruta + "\\" + "properties.txt");
			datosAGuardar = this.ip + " " + this.usuario + " " + this.contrasenia + " " + this.url;
			ficheroAGenerar.write(datosAGuardar);
			ficheroAGenerar.close();
		} catch (IOException e) {
			retornar = false;
		} // Fin try

		return retornar;
	}// Fin Función

	/**
	 * @return boolean Asigna los properties del fichero
	 */
	public boolean asignarProperties() {
		String[] datos;
		BufferedReader lecturaActual;
		boolean salida = true;

		try {
			lecturaActual = new BufferedReader(new FileReader(ruta.getAbsolutePath() + "\\properties.txt"));
			datos = lecturaActual.readLine().split(" ");

			this.ip = datos[0];
			this.usuario = datos[1];
			this.contrasenia = datos[2];
			this.url = datos[3];
		} catch (IOException e) {
			salida = false;
		} // Fin try

		return salida;
	}// Fin Procedimiento

}
