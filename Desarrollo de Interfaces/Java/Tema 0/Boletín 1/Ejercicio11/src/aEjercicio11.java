import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aEjercicio11 {
	public static String leerTeclado() {
		// Entorno+inicialización:
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String salida = null;

		// Algoritmo:
		try {
			salida = teclado.readLine();
		} catch (IOException e) {
			System.err.println("Error E/S");
		} // Fin try
		return salida;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno+inicialización:
		Diccionario dic;
		String palabra = null;

		// Algoritmo:
		do {
			System.out.print("Introduzca la palabra a buscar: ");
			palabra = leerTeclado();
		} while (palabra == null);

		dic = new Diccionario();
		if (dic.consulta(palabra) != null) {
			System.out.println("La traducción de " + palabra + " es: " + dic.consulta(palabra));
		} else {
			System.out.println("La palabra no está en el diccionario");
		} // Fin Si
	}// Fin Programa
}
