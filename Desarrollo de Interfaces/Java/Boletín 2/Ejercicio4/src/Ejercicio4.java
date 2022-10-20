import java.util.Random;

public class Ejercicio4 {
	public static int generaAleatorio(int desde, int hasta) {
		// Entorno:
		Random aleatorio;

		// Algoritmo:
		aleatorio = new Random();
		return aleatorio.nextInt(desde, hasta + 1);
	}// Fin Función

	public static void main(String[] args) {
		// Entorno:
		int max, min, media, actual;
		String salida;

		// Algoritmo:
		actual = generaAleatorio(100, 199);
		max = actual;
		min = actual;
		media = actual;
		salida = actual + " ";

		for (int i = 0; i < 49; i++) {
			actual = generaAleatorio(100, 199);

			if (max < actual) {
				max = actual;
			} else if (min > actual) {
				min = actual;
			} // Fin Si
			
			media += actual;
			salida += actual + " ";
		} // Fin Para
		media /= 50;
		
		System.out.println(salida);
		System.out.println("Máximo: " + max);
		System.out.println("Mínimo: " + min);
		System.out.println("Media: " + media);
	}// Fin Programa
}
