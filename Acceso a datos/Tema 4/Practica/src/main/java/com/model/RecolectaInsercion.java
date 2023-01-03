package com.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecolectaInsercion {
	/**
	 * La función de este método es crear un videojuego con los datos básicos
	 * 
	 * @return Videojuego
	 */
	public static Videojuego recoleccionDatosSencillos() {
		String tit, fecha, genero;
		float precio;

		/**
		 * Bloques para recoger los datos básicos sí o sí
		 */

		do {
			System.out.print("Inserte el título del juego: ");
			try {
				tit = recogerDatos();
			} catch (IOException e) {
				System.out.println("No ha insertado un título válido");
				tit = "";
			} // Fin try
		} while (tit.isEmpty() || tit == null);

		do {
			System.out.print("Inserte la fecha del juego(dd-mm-aaaa): ");
			try {
				fecha = recogerDatos();
				comprobarFecha(fecha);
			} catch (IOException e) {
				System.out.println("No ha insertado una fecha válida en el formato correcto");
				System.out.println("dd-mm-aaaa");
				fecha = "";
			} // Fin try
		} while (fecha.isEmpty() || fecha == null);

		do {
			System.out.print("Inserte el género del juego: ");
			try {
				genero = recogerDatos();
			} catch (IOException e) {
				System.out.println("No ha insertado un género válido");
				genero = "";
			} // Fin try
		} while (genero.isEmpty() || genero == null);

		do {
			System.out.print("Inserte el precio del juego: ");
			try {
				precio = Float.parseFloat(recogerDatos());
			} catch (IOException e) {
				System.out.println("No ha insertado un precio válido");
				precio = 0;
			} // Fin try
		} while (precio <= 0);

		Videojuego vj = new Videojuego(tit, fecha, genero, precio);
		return vj;

	}// Fin Función

	/**
	 * Este método hace que o bien cree un videojuego con todos los datos completos,
	 * o solamente el título si se quisiera
	 * 
	 * @return Videojuego
	 */
	public static Videojuego recoleccionDatos() {
		String titulo = null, fecha = null, diseniador = null, modo = null, plataforma = null, desarrollador = null,
				premio = null, genero = null, serie = null, nominacion = null, distribuidor = null;
		float precio = 0;

		String base = "Algo ha fallado al insertar el dato";

		do { // Solicitamos el título del videojuego obligatoriamente
			System.out.print("Inserte el título del videojuego: ");
			try {
				titulo = recogerDatos();
			} catch (IOException e) {
				System.out.println(base);
				titulo = null;
			} // Fin try
		} while (titulo.isEmpty() || titulo == null);

		/*
		 * A partir de aquí todo lo demás será opcional
		 */

		if (deseaContinuar("¿Quiere insertar la fecha del videojuego?")) {
			do {
				System.out.print("Inserte la fecha: ");
				try {
					fecha = recogerDatos();
					comprobarFecha(fecha);
				} catch (IOException e) {
					System.out.println("No ha introducido una fecha válida");
					fecha = null;
				} // Fin try
			} while (fecha.isEmpty() || fecha == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar al/los diseñador/es?")) {
			do {
				System.out.print("Inserte al/los diseñador/es: ");
				try {
					diseniador = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					diseniador = null;
				} // Fin try
			} while (diseniador.isEmpty() || diseniador == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar uno o varios modos?")) {
			do {
				System.out.print("Inserte el/los modo/s: ");
				try {
					modo = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					modo = null;
				} // Fin try
			} while (modo.isEmpty() || modo == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar una o varias plataformas?")) {
			do {
				System.out.print("Inserte la/las plataforma/s: ");
				try {
					plataforma = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					plataforma = null;
				} // Fin try
			} while (plataforma.isEmpty() || plataforma == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar uno o varios desarrollador/es?")) {
			do {
				System.out.print("Inserte el/los desarrollador/es: ");
				try {
					desarrollador = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					desarrollador = null;
				} // Fin try
			} while (desarrollador.isEmpty() || desarrollador == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar uno o varios premio/s?")) {
			do {
				System.out.print("Inserte el/los premio/s: ");
				try {
					premio = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					premio = null;
				} // Fin try
			} while (premio.isEmpty() || premio == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar uno o varios genero/s?")) {
			do {
				System.out.print("Inserte el/los genero/s: ");
				try {
					genero = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					genero = null;
				} // Fin try
			} while (genero.isEmpty() || genero == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar una o varias serie/s?")) {
			do {
				System.out.print("Inserte la/las serie/s: ");
				try {
					serie = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					serie = null;
				} // Fin try
			} while (serie.isEmpty() || serie == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar una o varias nominacion/es?")) {
			do {
				System.out.print("Inserte la/las nominacion/es: ");
				try {
					nominacion = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					nominacion = null;
				} // Fin try
			} while (nominacion.isEmpty() || nominacion == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar uno o varios distribuidor/es?")) {
			do {
				System.out.print("Inserte el/los distribuidor/es: ");
				try {
					distribuidor = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					diseniador = null;
				} // Fin try
			} while (distribuidor.isEmpty() || diseniador == null);
		} // Fin Mientras

		if (deseaContinuar("¿Quiere insertar el precio?")) {
			do {
				System.out.print("Inserte el precio del juego: ");
				try {
					precio = Float.parseFloat(recogerDatos());
				} catch (IOException e) {
					System.out.println("No ha insertado un precio válido");
					precio = 0;
				} // Fin try
			} while (precio == 0);
		} // Fin Mientras

		Videojuego vj = new Videojuego(titulo, fecha, diseniador, modo, plataforma, desarrollador, premio, genero,
				serie, nominacion, distribuidor, precio);
		return vj;
	}// Fin Función

	/**
	 * La función de este método es recoger líneas por teclado
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String recogerDatos() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		return teclado.readLine();
	}// Fin Función

	/**
	 * Está simplificado para que meta la longitud de datos exclusivamente
	 * 
	 * @param fecha
	 * @throws IOException
	 */
	public static void comprobarFecha(String fecha) throws IOException {
		if (fecha.length() != 10) {
			throw new IOException();
		} // Fin Si
	}// Fin Procedimiento

	/**
	 * Se encarga de comprobar si el usuario quiere o no seguir insertando.
	 * 
	 * @return boolean
	 */
	public static boolean deseaContinuar(String cad) {
		boolean salida;
		char c = 'u';

		do {
			System.out.print(cad + "(S/N): ");
			try {
				String respuesta = recogerDatos();
				c = respuesta.toLowerCase().charAt(0);
			} catch (IOException e) {
				System.out.println("No ha insertado un dato correcto");
			} // Fin try
		} while (c != 's' && c != 'n');

		salida = c == 's';

		return salida;
	}// Fin Función
}
