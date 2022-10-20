import java.util.Scanner;

public class aEjercicio11 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Entorno:
		Scanner sc;
		String tipo;
		GestionaAnfibios ga;

		// Algoritmo:
		tipo = "";
		sc = new Scanner(System.in);

		do {
			System.out.print("Introduzca el tipo de anfibio: ");
			tipo = sc.next();
		} while (tipo.isEmpty());

		ga = new GestionaAnfibios();
		ga.muestraTipo(tipo);
	}// Fin Programa
}
