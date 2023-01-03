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
				//Entorno:
				List<Videojuego> vjs = new LinkedList<Videojuego>();
				byte temp = 0;
				
				do {
					do {
						System.out.println("1. Desea insertar un videojuego sencillo (titulo, fecha(dd-mm-aaaa), genero, precio)");
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
					
					
				} while (RecolectaInsercion.deseaContinuar("¿Desea insertar otro videojuego?"));
				
//				List<Videojuego> vjs = recoleccionDatos();
				
				
				
				

				/**
				 * En el siguiente bloque hacemos la inserción a la BD.
				 */
				try {
					controlador.createVideojuegos(vjs);
				} catch (ParseException e) {
					System.out.println("Hubo un error al añadir el/los videojuego/s");
				} // Fin try
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
			System.out.println("\t3. Eliminar videojuego");
			System.out.println("\t4. Eliminar todos los videojuegos");
			System.out.println("\t5. Muestra videojuego");
			System.out.println("\t6. Buscar videojuego");
			System.out.println("\t9. Salir");
			System.out.print("Opción: ");

			try {
				salida = Byte.parseByte(RecolectaInsercion.recogerDatos());
				if (salida < 1 || salida > 6) {
					if (salida != 9) {
						throw new NumberFormatException();
					} // Fin Si
				} // Fin Si
			} catch (NumberFormatException e) {
				System.out.println("No ha metido una opción válida [1-6] y 9");
				esSalida = false;
			} catch (IOException e) {
				System.out.println("Error E/S");
				esSalida = false;
			} // Fin try
		} while (!esSalida);

		return salida;
	}// Fin Procedimiento
}
