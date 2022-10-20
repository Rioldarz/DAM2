import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
	public static byte leerTeclado() {
		// Entorno:
		BufferedReader teclado;
		byte retorno;

		// Algoritmo:
		teclado = new BufferedReader(new InputStreamReader(System.in));
		retorno = -1;

		try {
			retorno = Byte.parseByte(teclado.readLine());
		} catch (NumberFormatException e) {
			System.out.println("No ha metido un número");
		} catch (IOException e) {
			System.err.println("Error E/S");
		} // Fin trys

		return retorno;
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		byte dia, mes;
		String horoscopo;

		// Algoritmo:
		dia = -1;
		do {
			System.out.print("Introduzca el día del mes: ");
			dia = leerTeclado();
		} while (dia == -1);

		mes = -1;
		do {
			System.out.print("Introduzca el mes del año: ");
			mes = leerTeclado();
		} while (mes == -1);

		if (dia >= 22 && mes == 12 || dia <= 20 && mes == 1) {
			horoscopo = "Capricornio";
		} else if (dia >= 22 && mes == 12 || dia <= 20 && mes == 1) {
			horoscopo = "Capricornio";
		} else if (dia >= 21 && mes == 1 || dia <= 18 && mes == 2) {
			horoscopo = "Acuario";
		} else if (dia >= 19 && mes == 2 || dia <= 20 && mes == 3) {
			horoscopo = "Piscis";
		} else if (dia >= 21 && mes == 3 || dia <= 20 && mes == 4) {
			horoscopo = "Aries";
		} else if (dia >= 21 && mes == 4 || dia <= 20 && mes == 5) {
			horoscopo = "Tauro";
		} else if (dia >= 21 && mes == 5 || dia <= 21 && mes == 6) {
			horoscopo = "Géminis";
		} else if (dia >= 22 && mes == 6 || dia <= 22 && mes == 7) {
			horoscopo = "Cáncer";
		} else if (dia >= 23 && mes == 7 || dia <= 23 && mes == 8) {
			horoscopo = "Leo";
		} else if (dia >= 24 && mes == 8 || dia <= 23 && mes == 9) {
			horoscopo = "Virgo";
		} else if (dia >= 24 && mes == 9 || dia <= 23 && mes == 10) {
			horoscopo = "Libra";
		} else if (dia >= 24 && mes == 10 || dia <= 21 && mes == 11) {
			horoscopo = "Escorpio";
		} else {
			horoscopo = "Sagitario";
		} // Fin Si

		System.out.println("El horóscopo correspondiente a la fecha " + dia + "/" + mes + " es:");
		System.out.println(horoscopo);

	}// Fin Programa
}
