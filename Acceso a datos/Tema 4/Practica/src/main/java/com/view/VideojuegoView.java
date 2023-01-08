package com.view;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import com.controller.VideojuegoController;
import com.model.RecolectaInsercion;
import com.model.Videojuego;

public class VideojuegoView {

	public static void main(String[] args) {
		// Entorno + inicialización:
		VideojuegoController controlador = new VideojuegoController();
		byte opc;

		// Algoritmo:

		do {
			opc = menu();

			switch (opc) {
			/**
			 * El primer caso es para insertar en la BD con diferentes posibilidades.
			 */
			case 1:
				// Entorno + inicialización:
				Videojuego vj = null;
				List<Videojuego> vjs = new LinkedList<Videojuego>();
				byte temp = 0;

				do {
					do {
						System.out.println(
								"1. Desea insertar un videojuego sencillo (titulo, fecha(dd-mm-aaaa), genero, precio)");
						System.out.println("2. O Desea insertarlo con todos los datos que quiera");
						System.out.print("Escoja: ");

						try {
							temp = Byte.parseByte(RecolectaInsercion.recogerDatos());
						} catch (NumberFormatException e) {
							System.out.println("No ha metido un número en el formato correcto");
							temp = -1;
						} catch (IOException e) {
							System.out.println("Error E/S");
						} // Fin try
					} while (temp < 1 && temp > 2);

					/**
					 * Dentro de este bloque, según la opción de inserción que desee. Se hará uno u
					 * otro.
					 */
					switch (temp) {
					/**
					 * En el primer caso hacemos una inserción sencilla pero segura.
					 */
					case 1:
						vj = RecolectaInsercion.recoleccionDatosSencillos();
						break;
					case 2:
						vj = RecolectaInsercion.recoleccionDatos();
						break;
					}// Fin Según Sea

					vjs.add(vj);

				} while (RecolectaInsercion.deseaContinuar("¿Desea insertar otro videojuego?"));

				/**
				 * En el siguiente bloque hacemos la inserción a la BD.
				 */
				try {
					controlador.createVideojuegos(vjs);
				} catch (ParseException e) {
					System.out.println("Hubo un error al añadir el/los videojuego/s");
				} // Fin try
				break;
			case 2:
				// Entorno + inicialización:
				String titJuego = null;

				// Algoritmo:
				do {
					do {
						System.out.print("Inserte el título del juego que desea modificar: ");
						try {
							titJuego = RecolectaInsercion.recogerDatos();
						} catch (IOException e) {
							System.out.println("Error E/S");
						} // Fin try

						while (titJuego == null || titJuego.isEmpty()) {
							System.out.print("Inserte el título del juego que desea modificar: ");
							try {
								titJuego = RecolectaInsercion.recogerDatos();
							} catch (IOException e) {
								System.out.println("Error E/S");
							} // Fin try
						} // Fin Mientras
					} while (!controlador.corroboraVideojuego(titJuego));

					System.out.println("Ahora inserte los datos que le gustaría modificar:");
					vj = RecolectaInsercion.recoleccionDatos();

					try {
						controlador.updateVideojuego(titJuego, vj.datosSeparados());
					} catch (ParseException e) {
						System.out.println("Hubo un error al actualizar el videojuego");
					} // Fin try
				} while (RecolectaInsercion.deseaContinuar("¿Desea actualizar otro videojuego?"));

				break;
			case 3:
				// Entorno + inicialización:
				String nombreJuego = null;
				Videojuego vj1 = null;
				List<Videojuego> vjs1 = new LinkedList<Videojuego>();

				// Algoritmo:
				do {
					System.out.print("¿Qué videojuego desea reemplazar?: ");
					try {
						nombreJuego = RecolectaInsercion.recogerDatos();
					} catch (IOException e1) {
						System.out.println("Error E/S");
					} // Fin try

					while (nombreJuego == null || nombreJuego.isEmpty()) {
						System.out.print("¿Qué videojuego desea reemplazar?: ");
						try {
							titJuego = RecolectaInsercion.recogerDatos();
						} catch (IOException e) {
							System.out.println("Error E/S");
						} // Fin try
					} // Fin Mientras
				} while (!controlador.corroboraVideojuego(nombreJuego));

				System.out.println(
						"Inserte los nuevos datos que desee que tenga el juego por el cual lo quiera reemplazar:");
				vj1 = RecolectaInsercion.recoleccionDatos();
				vjs1.add(vj1);

				if (RecolectaInsercion.deseaContinuar("¿Está seguro de que desea reemplazarlo?")) {
					controlador.deleteVideojuego(nombreJuego);

					try {
						controlador.createVideojuegos(vjs1);
					} catch (ParseException e) {
						System.out.println("Hubo un error al añadir el/los videojuego/s");
					} // Fin try
				} else {
					System.out.println("El juego no será reemplazado");
				} // Fin Si

				break;
			case 4:
				// Entorno + inicialización:
				String tit = null;

				// Algoritmo:
				do {
					do {
						System.out.print("Inserte el nombre del videojuego que desea eliminar: ");
						try {
							tit = RecolectaInsercion.recogerDatos();
						} catch (IOException e) {
							System.out.println("Error E/S");
						} // Fin try

						while (tit == null || tit.isEmpty()) {
							System.out.print("Inserte el nombre del videojuego que desea eliminar: ");
							try {
								tit = RecolectaInsercion.recogerDatos();
							} catch (IOException e) {
								System.out.println("Error E/S");
							} // Fin try
						} // Fin Mientras
					} while (!controlador.deleteVideojuego(tit));
				} while (RecolectaInsercion.deseaContinuar("¿Desea eliminar otro videojuego?"));

				break;
			case 5:
				if (RecolectaInsercion.deseaContinuar("¿Está seguro de querer borrar todos los videojuegos?")) {
					controlador.deleteVideojuegos();
				} // Fin Si

				break;
			case 6:
				if (RecolectaInsercion.deseaContinuar("¿Está seguro de querer mostrar todos los videojuegos?")) {
					controlador.mostrarTodos();
				} // Fin Si

				break;
			case 7:
				// Entorno + inicialización:
				String titu = null;

				// Algoritmo:
				do {
					do {
						System.out.print("Inserte el nombre del videojuego que desea buscar: ");
						try {
							titu = RecolectaInsercion.recogerDatos();
						} catch (IOException e) {
							System.out.println("Error E/S");
						} // Fin try

						while (titu == null || titu.isEmpty()) {
							System.out.print("Inserte el nombre del videojuego que desea buscar: ");
							try {
								tit = RecolectaInsercion.recogerDatos();
							} catch (IOException e) {
								System.out.println("Error E/S");
							} // Fin try
						} // Fin Mientras
					} while (!controlador.buscaVideojuego(titu));
				} while (RecolectaInsercion.deseaContinuar("¿Desea buscar otro videojuego?"));

				break;
			case 8:
				if (controlador.exportaJSON()) {
					System.out.println("JSON exportado con éxito en la carpeta del programa.");
				} else {
					System.out.println("Ha habido un error al exportar el JSON.");
				} // Fin Si

				if (controlador.exportaCSV()) {
					System.out.println("CSV exportado con éxito en la carpeta del programa.");
				} else {
					System.out.println("Ha habido un error al exportar el CSV.");
				} // Fin Si

				break;
			}// Fin Según Sea
		} while (opc != 9);
	}// Fin Programa

	/**
	 * Esta función se encarga de mostrar el menú y recoger la opción del usuario.
	 * 
	 * @return byte
	 */
	public static byte menu() {
		// Entorno + inicialización:
		boolean esSalida;
		byte salida = 0;

		// Algoritmo:
		do {
			esSalida = true;
			System.out.println("¿Qué desea hacer?:");
			System.out.println("\t1. Dar de alta uno o varios videojuegos");
			System.out.println("\t2. Modificar uno o varios videojuegos");
			System.out.println("\t3. Reemplazar videojuego");
			System.out.println("\t4. Eliminar videojuego");
			System.out.println("\t5. Eliminar todos los videojuegos");
			System.out.println("\t6. Mostrar videojuegos");
			System.out.println("\t7. Buscar videojuego");
			System.out.println("\t8. Exportar BD a CSV y JSON");
			System.out.println("\t9. Salir");
			System.out.print("Opción: ");

			try {
				salida = Byte.parseByte(RecolectaInsercion.recogerDatos());
				if (salida < 1 || salida > 8) {
					if (salida != 9) {
						throw new NumberFormatException();
					} // Fin Si
				} // Fin Si
			} catch (NumberFormatException e) {
				System.out.println("No ha metido una opción válida [1-7] y 9");
				esSalida = false;
			} catch (IOException e) {
				System.out.println("Error E/S");
				esSalida = false;
			} // Fin try
		} while (!esSalida);

		return salida;
	}// Fin Procedimiento
}
