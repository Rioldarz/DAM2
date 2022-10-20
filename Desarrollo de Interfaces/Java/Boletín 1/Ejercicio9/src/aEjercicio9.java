import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aEjercicio9 {
	public static String leerCadena() {
		// Entorno:
		BufferedReader teclado;
		String salida;

		// Algoritmo
		teclado = new BufferedReader(new InputStreamReader(System.in));
		salida = null;

		do {
			System.out.print("Introduzca su nombre: ");
			try {
				salida = teclado.readLine();

				char[] comprobante = salida.toLowerCase().toCharArray();
				byte i = 0;
				while (i < comprobante.length && comprobante[i] >= 97 && comprobante[i] <= 122) {
					i++;
				} // Fin Mientras

				if (i != comprobante.length) {
					salida = null;
				} // Fin Si
			} catch (IOException e) {
				System.err.println("Error E/S");
			}//Fin try

		} while (salida == null);

		System.out.println(salida);
		return salida;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		GuardaFichero ficherete;

		// Agoritmo:
		ficherete = new GuardaFichero(leerCadena());
		ficherete.construyeFichero();
	}// Fin Programa
}
