package com.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

	public static String recogerDatos() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		return teclado.readLine();
	}// Fin Función

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

	public static void main(String[] args) {
		// Entorno:
		boolean esSalir = false;
		VideojuegoController controlador = new VideojuegoController();
		byte opc;
		Scanner sc = new Scanner(System.in);

		// Algoritmo:
		do {
			menu();
			opc = sc.nextByte();

			switch (opc) {
			case 1:
				byte temp = 0;
				do {
					System.out.println(
							"1. Desea insertar un videojuego sencillo (titulo, fecha(dd-mm-aaaa), genero, precio)");
					System.out.println("2. Desea insertarlo con todos los datos");
					System.out.println("3. O desea insertar datos sobre la marcha a su gusto");
					System.out.print("Escoja: ");
					temp = sc.nextByte();
				} while (temp < 1 && temp > 3);

				switch (temp) {
				case 1:
					String tit = "", fecha = "", genero = "";
					float precio = 0;

					do {
						System.out.print("Inserte el título del juego: ");
						try {
							tit = recogerDatos();
						} catch (IOException e) {
							System.out.println("No ha insertado un título válido");
							tit = "";
						} // Fin try
					} while (tit.isEmpty());

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

					do {
						System.out.print("Inserte el género del juego: ");
						try {
							genero = recogerDatos();
						} catch (IOException e) {
							System.out.println("No ha insertado un género válido");
							genero = "";
						} // Fin try
					} while (genero.isEmpty());

					do {
						System.out.print("Inserte el precio del juego: ");
						try {
							precio = Float.parseFloat(recogerDatos());
						} catch (IOException e) {
							System.out.println("No ha insertado un precio válido");
							precio = 0;
						} // Fin try
					} while (precio == 0);

					Videojuego vj = new Videojuego(tit, fecha, genero, precio);
					List<Videojuego> vjs = new LinkedList<Videojuego>();
					vjs.add(vj);

					try {
						controlador.createVideojuegos(vjs);
					} catch (ParseException e) {
						System.out.println("Hubo un error al añadir el videojuego simple");
					}//Fin try

					break;
				case 2:
					break;
				case 3:
					break;
				}// Fin Según Sea

				break;
			case 2:
				break;
			}// Fin Según Sea
		} while (!esSalir);
	}

}
