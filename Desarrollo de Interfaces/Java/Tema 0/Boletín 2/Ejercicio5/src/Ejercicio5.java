import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		// Entorno:
		ArrayList<Integer> lista = new ArrayList<Integer>(10);
		Scanner sc = new Scanner(System.in);

		// Algoritmo:
		for (int i = 0; i < 10; i++) {
			System.out.print("Introduzca número (" + (i + 1) + "): ");
			lista.add(sc.nextInt());
		} // Fin Para

		System.out.println();

		for (int i = 10; i > 0; i--) {
			System.out.println(lista.get(i - 1));
		} // Fin Si
	}//Fin Programa
}
