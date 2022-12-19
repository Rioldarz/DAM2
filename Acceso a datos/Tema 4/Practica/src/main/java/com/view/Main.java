package com.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import com.controller.VideojuegoController;
import com.model.Videojuego;

public class Main {
	public static void menu() {
		System.out.println("¿Qué desea hacer?:");
		System.out.println("\t1. Dar de alta uno o varios videojuegos");
		System.out.println("\t2. Modificar uno o varios videojuegos");
		System.out.println("\t3. Eliminar videojuego");
		System.out.println("\t4. Eliminar todos los videojuegos");
		System.out.println("\t5. Muestra videojuego");
		System.out.println("\t6. Buscar videojuego");
		System.out.println("\t9. Salir");
		System.out.print("Opción: ");
	}// Fin Procedimiento

	public static void main(String[] args) {
		// Entorno:
		boolean esSalir = false;
		VideojuegoController controlador = new VideojuegoController();
		byte opc;

		// Algoritmo:
		do {
			/**
			 * En el siguiente bloque lo que hacemos es pedir la opción deseada para hacer y
			 * asegurarnos de que así sea. Es decir, repetir si ha metido mal el dato sin
			 * que le lleguen los errores.
			 */
			opc = -1;
			do {
				menu();
				try {
					opc = Byte.parseByte(recogerDatos());
				} catch (NumberFormatException e1) {
					System.out.println("No ha metido un número en el formato correcto");
					opc = -1;
				} catch (IOException e1) {
					System.out.println("Error E/S");
				} // Fin try
			} while (opc == -1);

			/**
			 * En el siguiente bloque en base a la opción escogida trabajamos según
			 * corresponda.
			 */
			switch (opc) {
			/**
			 * El primer caso es para insertar en la BD con diferentes posibilidades.
			 */
			case 1:
				byte temp = 0;
				do {
					System.out.println(
							"1. Desea insertar un videojuego sencillo (titulo, fecha(dd-mm-aaaa), genero, precio)");
					System.out.println("2. O Desea insertarlo con todos los datos que quiera");
					System.out.print("Escoja: ");

					try {
						temp = Byte.parseByte(recogerDatos());
					} catch (NumberFormatException e1) {
						System.out.println("No ha metido un número en el formato correcto");
						temp = -1;
					} catch (IOException e1) {
						System.out.println("Error E/S");
					} // Fin try
				} while (temp < 1 && temp > 3);

				switch (temp) {
				/**
				 * Dentro de este bloque, según la opción de inserción que desee. Se hará uno u
				 * otro.
				 */
				case 1:
					/**
					 * Creamos la lista a insertar en la BD.
					 */
					List<Videojuego> vjs = new LinkedList<Videojuego>();

					do {
						String tit = "", fecha = "", genero = "";
						float precio = 0;

						/**
						 * El siguiente bloque se encarga de recoger sí o sí el título del juego sin
						 * opción a error. Ahora ya que el usuario lo meta bien o no depende de él.
						 */
						do {
							System.out.print("Inserte el título del juego: ");
							try {
								tit = recogerDatos();
							} catch (IOException e) {
								System.out.println("No ha insertado un título válido");
								tit = "";
							} // Fin try
						} while (tit.isEmpty());

						/**
						 * El siguiente bloque se encarga de recoger la fecha de salida del juego.
						 * Teniendo como limitante el año aproximado del primer videojuego(1950) y hasta
						 * 2030.
						 */
						do {
							System.out.println("Recordemos que los videojuegos empezaron en 1950");
							System.out.println("Y máximo habrá planificados entre hoy y 2030");
							System.out.print("Inserte la fecha del juego: ");
							try {
								fecha = recogerDatos();
								comprobarFecha(fecha);
							} catch (IOException e) {
								System.out.println("No ha insertado una fecha válida en el formato correcto");
								System.out.println("dd-mm-aaaa");
								fecha = "";
							} // Fin try
						} while (fecha.isEmpty());

						/**
						 * En el siguiente bloque recogemos el género del juego sin posibilidad a error.
						 * Menos si el usuario lo mete mal.
						 */
						do {
							System.out.print("Inserte el género del juego: ");
							try {
								genero = recogerDatos();
							} catch (IOException e) {
								System.out.println("No ha insertado un género válido");
								genero = "";
							} // Fin try
						} while (genero.isEmpty());

						/**
						 * En este bloque metemos su precio asegurándonos que sí o sí meta al menos un
						 * número.
						 */
						do {
							System.out.print("Inserte el precio del juego: ");
							try {
								precio = Float.parseFloat(recogerDatos());
							} catch (IOException e) {
								System.out.println("No ha insertado un precio válido");
								precio = 0;
							} // Fin try
						} while (precio == 0);

						/**
						 * En las siguiente 2 líneas creamos el videojuego per se, añadiéndolo a la lista de inserción.
						 */
						Videojuego vj = new Videojuego(tit, fecha, genero, precio);
						vjs.add(vj);

					} while (deseaContinuar());
					
					/**
					 * Y en el siguiente bloque creamos el videojuego en la BD.
					 */
					try {
						controlador.createVideojuegos(vjs);
					} catch (ParseException e) {
						System.out.println("Hubo un error al añadir el/los videojuego/s simple/s");
					} // Fin try

					break;
				case 2:
					break;
				}// Fin Según Sea

				break;
			case 2:
				break;
			}// Fin Según Sea
		} while (!esSalir);
	}// Fin Programa

	/**
	 * Esta función lo que hace es recoger una cade completa por teclado.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public static String recogerDatos() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		return teclado.readLine();
	}// Fin Función

	/**
	 * Este procedimiento provoca una explosión si la fecha no está bien formateada.
	 * 
	 * @param fecha
	 * @throws IOException
	 */
	public static void comprobarFecha(String fecha) throws IOException {
		String[] comprobante = fecha.split("-");

		if (fecha.length() != 10) {
			throw new IOException();
		} else if (comprobante.length != 3) {
			throw new IOException();
		} // Fin Si
//
//		if (comprobante[0].length() == 2) {
//			try {
//				byte temp = Byte.parseByte(comprobante[0]);
//
//				if (temp < 1 || temp > 31) {
//					throw new IOException();
//				} // Fin Si
//
//			} catch (NumberFormatException e) {
//				throw new IOException();
//			} // Fin try
//		} else {
//			throw new IOException();
//		} // Fin Si
//
//		if (comprobante[1].length() == 2) {
//			try {
//				byte temp = Byte.parseByte(comprobante[1]);
//
//				if (temp < 1 || temp > 12) {
//					throw new IOException();
//				} // Fin Si
//
//			} catch (NumberFormatException e) {
//				throw new IOException();
//			} // Fin try
//		} else {
//			throw new IOException();
//		} // Fin Si
//
//		if (comprobante[2].length() == 4) {
//			try {
//				short temp = Short.parseShort(comprobante[1]);
//
//				if (temp < 1950 || temp > 2030) {
//					throw new IOException();
//				} // Fin Si
//
//			} catch (NumberFormatException e) {
//				throw new IOException();
//			} // Fin try
//		} else {
//			throw new IOException();
//		} // Fin Si

	}// Fin Procedimiento

	public static boolean deseaContinuar() {
		boolean salida;
		char c = 'u';

		do {
			System.out.print("¿Desea insertar otro videojuego?(S/N): ");
			try {
				String respuesta = recogerDatos();
				c = respuesta.toLowerCase().charAt(0);
			} catch (IOException e) {
				System.out.println("No ha insertado un dato correcto");
			} // Fin try
		} while (c != 's' && c != 'n');

		salida = c == 's';

		return salida;
	}//Fin Función
}
