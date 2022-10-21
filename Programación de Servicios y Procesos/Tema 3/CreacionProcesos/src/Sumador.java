
public class Sumador {
	public static int sumar(int numero1, int numero2) {
		int suma = 0;
		for (int i = numero1; i <= numero2; i++) {
			suma += i;
		} // Fin Para
		return suma;
	}// Fin Función

	public static void main(String[] args) {
		int numero1 = Integer.valueOf(args[0]);
		int numero2 = Integer.valueOf(args[1]);

		int suma = sumar(numero1, numero2); //Hasta aquí es del EjemploVideo1
//		System.out.print("Sumo desde " + numero1 + " hasta " + numero2 + ": ");
//		System.out.println(sumar(numero1, numero2	)); //Hasta aquí es del EjemploVideo2
	}// Fin Programa
}
