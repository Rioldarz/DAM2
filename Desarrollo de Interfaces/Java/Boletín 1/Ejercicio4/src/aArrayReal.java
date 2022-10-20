import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class aArrayReal {
	public static boolean esContinuar() {
		// Entorno:
		BufferedReader teclado;
		String respuesta;

		// Algoritmo:
		teclado = new BufferedReader(new InputStreamReader(System.in));
		respuesta = null;

		System.out.print("¿Desea continuar? (S): ");
		try {
			respuesta = teclado.readLine();
		} catch (IOException e) {
			System.err.println("Error E/S");
		} // Fin try

		return respuesta.compareToIgnoreCase("s") == 0;
	}// Fin Función

	public static double leerTeclado() {
		// Entorno:
		BufferedReader teclado;
		double retorno;

		// Algoritmo:
		teclado = new BufferedReader(new InputStreamReader(System.in));
		retorno = Double.MIN_VALUE;

		try {
			retorno = Double.parseDouble(teclado.readLine());
		} catch (NumberFormatException e) {
			System.out.println("No ha introducido un número");
			retorno = Double.MIN_VALUE;
		} catch (IOException e) {
			System.err.println("Error E/S");
		} // Fin Try

		return retorno;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		LinkedList<Double> vector;
		double doubleInsertado;
		ArrayReal miArray;

		// Algoritmo:
		vector = new LinkedList<>();
		doubleInsertado = Double.MIN_VALUE;

		do {
			do {
				System.out.print("¿Qué valor desea insertar en la posición " + (vector.size()+1) + "?: ");
				doubleInsertado = leerTeclado();
			} while (doubleInsertado == Double.MIN_VALUE);
			vector.add(doubleInsertado);
		} while (esContinuar());

		miArray = new ArrayReal(vector);
		System.out.println("El valor mínimo es: " + miArray.minimo());
		System.out.println("El valor maxímo es: " + miArray.maximo());
		System.out.println("El sumatorio es: " + miArray.sumatorio());
	}// Fin Programa
}
