package com.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import com.controller.VideojuegoController;
import com.model.Videojuego;

public class MainN {

	public static void main(String[] args) {
		// Entorno + inicialización:
		VideojuegoController controlador = new VideojuegoController();
		byte opc = -1;

		// Algoritmo:
		do {
			opc = menu();

			switch (opc) {
			/**
			 * El primer caso es para insertar en la BD con diferentes posibilidades.
			 */
			case 1:
				List<Videojuego> vjs = recoleccionDatos();

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
				salida = Byte.parseByte(recogerDatos());
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

	/**
	 * Esta función lo que hace es recoger una cadena completa por teclado.
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
	 * HAY QUE CORREGIR Y MEJORAR ESTO
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

	/**
	 * Devuelve la lista de videojuegos que desea insertar en la BD. Pudiendo elegir
	 * entre un formato sencillo pero seguro u otro a su elección.
	 * 
	 * @return List<Videojuego>
	 */
	public static List<Videojuego> recoleccionDatos() {
		// Entorno + inicialización:
		List<Videojuego> vjs = new LinkedList<Videojuego>();
		byte temp = 0;

		// Algoritmo:
		do {
			System.out.println("1. Desea insertar un videojuego sencillo (titulo, fecha(dd-mm-aaaa), genero, precio)");
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
				 * En las siguiente 2 líneas creamos el videojuego per se, añadiéndolo a la
				 * lista de inserción.
				 */
				Videojuego vj = new Videojuego(tit, fecha, genero, precio);
				vjs.add(vj);

			} while (deseaContinuar("¿Desea insertar otro videojuego?"));
			break;
		case 2:
			String base = "No ha introducido un dato válido";

			/**
			 * Pedimos el título del videojuego
			 */
			String titulo = "";
			do {
				System.out.print("Inserte el título del videojuego: ");
				try {
					titulo = recogerDatos();
				} catch (IOException e) {
					System.out.println(base);
					titulo = "";
				} // Fin try
			} while (titulo.isEmpty());

			/**
			 * Si quiere añadimos la fecha y si no la dejamos vacía para mantener la
			 * estructura
			 */
			String fecha = "";
			if (deseaContinuar("¿Quiere insertar la fecha del videojuego?")) {
				do {
					System.out.print("Inserte la fecha: ");
					try {
						fecha = recogerDatos();
						comprobarFecha(fecha);
					} catch (IOException e) {
						System.out.println("No ha introducido una fecha válida");
						fecha = "";
					} // Fin try
				} while (fecha.isEmpty());
			} // Fin Mientras

			/**
			 * Si quiere añadimos al/los diseñador/es y si no lo dejamos vacío para mantener
			 * la estructura
			 */
			String diseniador = "";
			if (deseaContinuar("¿Quiere insertar al/los diseñador/es?")) {
				do {
					System.out.print("Inserte al/los diseñador/es: ");
					try {
						diseniador = recogerDatos();
					} catch (IOException e) {
						System.out.println(base);
					} // Fin try
				} while (diseniador.isEmpty());
			} // Fin Mientras
			
			String modo = "";
			if(deseaContinuar("¿Quiere insertar uno o varios modos?")) {
				do {
					System.out.print("Inserte el/los modo/s: ");
					try {
						modo = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (modo.isEmpty());
			}//Fin Mientras
			
			String plataforma = "";
			if(deseaContinuar("¿Quiere insertar una o varias plataformas?")) {
				do {
					System.out.print("Inserte la/las plataforma/s: ");
					try {
						plataforma = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (plataforma.isEmpty());
			}//Fin Mientras
			
			String desarrollador = "";
			if(deseaContinuar("¿Quiere insertar uno o varios desarrollador/es?")) {
				do {
					System.out.print("Inserte el/los desarrollador/es: ");
					try {
						desarrollador = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (desarrollador.isEmpty());
			}//Fin Mientras
			
			String premio = "";
			if(deseaContinuar("¿Quiere insertar uno o varios premio/s?")) {
				do {
					System.out.print("Inserte el/los premio/s: ");
					try {
						premio = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (premio.isEmpty());
			}//Fin Mientras
			
			String genero = "";
			if(deseaContinuar("¿Quiere insertar uno o varios genero/s?")) {
				do {
					System.out.print("Inserte el/los genero/s: ");
					try {
						genero = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (genero.isEmpty());
			}//Fin Mientras
			
			String serie = "";
			if(deseaContinuar("¿Quiere insertar una o varias serie/s?")) {
				do {
					System.out.print("Inserte la/las serie/s: ");
					try {
						serie = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (serie.isEmpty());
			}//Fin Mientras
			
			String nominacion = "";
			if(deseaContinuar("¿Quiere insertar una o varias nominacion/es?")) {
				do {
					System.out.print("Inserte la/las nominacion/es: ");
					try {
						nominacion = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (nominacion.isEmpty());
			}//Fin Mientras
			
			String distribuidor = "";
			if(deseaContinuar("¿Quiere insertar uno o varios distribuidor/es?")) {
				do {
					System.out.print("Inserte el/los distribuidor/es: ");
					try {
						distribuidor = recogerDatos();
					}catch (IOException e) {
						System.out.println(base);
					}//Fin try
				} while (distribuidor.isEmpty());
			}//Fin Mientras
			
			Float precio = 0f;
			if(deseaContinuar("¿Quiere insertar el precio?")) {
				do {
					System.out.print("Inserte el precio del juego: ");
					try {
						precio = Float.parseFloat(recogerDatos());
					} catch (IOException e) {
						System.out.println("No ha insertado un precio válido");
						precio = 0f;
					} // Fin try
				} while (precio == 0);
			}//Fin Mientras
			
			Videojuego vj = new Videojuego(titulo, fecha, diseniador, modo, plataforma, desarrollador, premio, genero, serie, nominacion, distribuidor, precio);
			vjs.add(vj);
			break;
		}// Fin Según Sea
		return vjs;
	}// Fin Función
}
