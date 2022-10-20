import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Ejercicio1 {
	public static String lecturaTeclado() {
		// Entorno:
		BufferedReader teclado;
		String contenidoTeclado;

		// Algoritmo:
		teclado = new BufferedReader(new InputStreamReader(System.in));
		contenidoTeclado = "20220927x9:15";

		do {
			System.out.print("Introduzca número o \"FIN\": ");
			try {
				contenidoTeclado = teclado.readLine();

				Float.parseFloat(contenidoTeclado);
			} catch (IOException e) {
				System.err.println("Error E/S");
			} catch (NumberFormatException nfe) {
				if (!contenidoTeclado.equalsIgnoreCase("FIN")) {
					contenidoTeclado = "20220927x9:15";
					System.out.println("Lo que ha introducido no es un número");
				} // Fin Si
			} // Fin try
		} while (contenidoTeclado == "20220927x9:15");

		return contenidoTeclado;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		float acumulador, media;
		short contador, i;
		boolean esContinuar;
		String recogida;
		LinkedList<Float> numeros;

		// Algoritmo:
		acumulador = 0;
		contador = 0;
		esContinuar = true;
		numeros = new LinkedList<Float>();

		while (esContinuar) {
			recogida = lecturaTeclado();
			if (!recogida.equalsIgnoreCase("FIN")) {
				numeros.add(Float.parseFloat(recogida));
				acumulador += Float.parseFloat(recogida);
				contador++;
			} else {
				esContinuar = false;
			} // Fin Si
		} // Fin Mientras

		media = acumulador / contador;

		System.out.print("Los números introducidos son: ");
		for (i = 0; i < numeros.size() - 1; i++) {
			System.out.print(numeros.get(i) + ", ");
		} // Fin Para
		System.out.println(numeros.get(i));
		System.out.println("La cantidad de lecturas realizadas: " + contador);
		System.out.println("Y el valor medio calculado: " + media);

	}// Fin Programa
}
