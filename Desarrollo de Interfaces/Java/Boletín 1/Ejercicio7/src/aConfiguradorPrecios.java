import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aConfiguradorPrecios {
	public static String leerTeclado() {
		// Entorno:
		BufferedReader teclado;
		String recogida;

		// Algoritmo:
		teclado = new BufferedReader(new InputStreamReader(System.in));
		recogida = null;

		try {
			recogida = teclado.readLine();
		} catch (IOException e) {
			System.err.print("Error E/S");
		} // Fin try

		return recogida;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		ConfiguradorPrecios confipre;
		float ancho, alto;
		boolean escudo, esSalida;
		String localidad;
		char[] comprobante;
		byte i;

		// Algoritmo:
		do {
			System.out.print("Introducir el ancho de la bandera (en cm): ");
			try {
				ancho = Float.parseFloat(leerTeclado());
			} catch (NumberFormatException nfe) {
				System.out.println("No ha introducido un dato correcto");
				ancho = Float.MIN_VALUE;
			} // Fin try
		} while (ancho == Float.MIN_VALUE);

		do {
			System.out.print("Introducir el alto de la bandera (en cm): ");
			try {
				alto = Float.parseFloat(leerTeclado());
			} catch (NumberFormatException nfe) {
				System.out.println("No ha introducido un dato correcto");
				alto = Float.MIN_VALUE;
			} // Fin try
		} while (alto == Float.MIN_VALUE);

		escudo = false;
		do {
			esSalida = true;
			System.out.print("¿Quiere escudo? (s/n): ");
			if (leerTeclado().equalsIgnoreCase("S")) {
				escudo = true;
			} else if (leerTeclado().equalsIgnoreCase("N")) {
				escudo = false;
			} else {
				System.out.println("No ha introducido un dato correcto");
				esSalida = false;
			} // Fin Si
		} while (!esSalida);
		
		do {
			esSalida = true;
			System.out.print("Localidad de envío: ");
			localidad = leerTeclado();
			
			comprobante = localidad.toLowerCase().toCharArray();
			i = 0;
			while (i < comprobante.length && comprobante[i] >= 97 && comprobante[i] <= 122) {
				i++;
			}//Fin Mientras
			
			if (i != comprobante.length) {
				esSalida = false;
				System.out.println("No ha introducido un dato correcto");
			}//Fin Si
		} while (!esSalida);
		
		confipre = new ConfiguradorPrecios(ancho, alto, escudo, localidad);
		System.out.println("Bandera XXX cm2 = " + confipre.precioBandera() + "€");
		System.out.println("Escudo = " + confipre.precioEscudo() + "€");
		System.out.println("Gastos de envio = " + confipre.gastoEnvio() + "€");
		System.out.println("Total pedido = " + confipre.calculaPrecioTotal() + "€");

	}// Fin Programa
}
