import java.util.Scanner;

public class Ejercicio1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Float nota1, nota2, mediaDeseada;
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca la nota del primer parcial: ");
		nota1 = sc.nextFloat();
		System.out.print("¿Cuál es su media deseada?: ");
		mediaDeseada = sc.nextFloat();

		nota2 = (mediaDeseada * 100 - nota1 * 40) / 60;
		System.out.println("La nota que debería sacar en el segundo parcial es: " + nota2);
	}// Fin Programa
}
