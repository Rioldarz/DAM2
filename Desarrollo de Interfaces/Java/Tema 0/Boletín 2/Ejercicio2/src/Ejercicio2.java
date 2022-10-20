import java.util.Scanner;

public class Ejercicio2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Entorno:
		int piso, longLinea, espaciosVacios, altura;
		Scanner sc = new Scanner(System.in);
		String caracter;

		// Algoritmo:
		System.out.print("Introduzce la altura de la pirámide: ");
		altura = sc.nextInt();
		System.out.print("Introduce el alfanumérico como caracter: ");
		caracter = sc.next();

		piso = 1;
		longLinea = 1;
		espaciosVacios = altura - 1;
		while (piso <= altura) {

			// Espacios
			for (int i = 1; i <= espaciosVacios; i++) {
				System.out.print(" ");
			} // Fin Para

			// Líneas
			for (int i = 1; i <= longLinea; i++) {
				System.out.print(caracter);
			} // Fin Para

			System.out.println();

			piso++;
			espaciosVacios--;
			longLinea += 2;
		} // Fin Mientras
	}// Fin Programa
}
