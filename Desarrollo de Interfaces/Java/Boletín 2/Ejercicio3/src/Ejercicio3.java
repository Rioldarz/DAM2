
public class Ejercicio3 {
	public static void main(String args[]) {
		//Entorno:
		int i, j, div, raiz;
		String salida;
		
		//Algoritmo:
		j = 0;
		div = 0;
		raiz = 0;
		salida = "";
		
		for (i = 2; i < 101; i++) {
			div = 0;
			raiz = (int) Math.sqrt(i);
			for (j = 1; j <= raiz; j++) {
				if (i % j == 0) {
					div++;
				} // Fin Si
			} // Fin Para
			if (div <= 1) {
				salida += i + ", ";
			} // Fin Si
		} // Fin Para
		
		System.out.println(salida.substring(0, salida.length()-2));
		
	}// Fin Programa
}
