import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {
	public static String leerMes() {
		// Entorno:
		BufferedReader teclado;
		byte mesIntroducido;
		String retorno;
		String[] nombreMeses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		// Algoritmo:
		teclado = new BufferedReader(new InputStreamReader(System.in));
		mesIntroducido = -1;
		retorno = "No existe ese mes";

		System.out.print("Introduzca el mes: ");
		try {
			mesIntroducido = Byte.parseByte(teclado.readLine());
		} catch (IOException e) {
			System.err.println("Error E/S");
		} catch (NumberFormatException nfe) {
			// No voy a hacer nada, solo lo capturo para propagar
		} // Fin try

		if (mesIntroducido >= 1 && mesIntroducido <= 12) {
			retorno = nombreMeses[mesIntroducido - 1];
		} // Fin Si

		return retorno;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		String mes;

		// Algoritmo:
		mes = leerMes();
		System.out.println(mes);
	}// Fin Programa
}
