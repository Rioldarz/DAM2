import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio6 {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		// Entorno:
		ArrayList<Integer> lista = new ArrayList<Integer>(10);
		int max, min;
		Scanner sc = new Scanner(System.in);

		// Algoritmo:
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			System.out.print("Introduzca número (" + (i + 1) + "): ");
			lista.add(sc.nextInt());

			if (max < lista.get(i)) {
				max = lista.get(i);
			} // Fin Si
			if (min > lista.get(i)) {
				min = lista.get(i);
			} // Fin Si
		} // Fin Para
		System.out.println();

		Iterator<Integer> it = lista.iterator();
		while (it.hasNext()) {
			int siguiente = it.next();
			String salida;

			if (siguiente == max) {
				salida = siguiente + " máximo";
			} else if (siguiente == min) {
				salida = siguiente + " mínimo";
			} else {
				salida = String.valueOf(siguiente);
			} // Fin Si

			System.out.println(salida);
		} // Fin Mientras
	}// Fin Programa
}
