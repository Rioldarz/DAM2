import java.util.Scanner;

public class aEjercicio8 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Mesas mes = new Mesas();
		byte i = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println(mes.generaSalida());
			System.out.print("¿Cuántos son? (Introduzca -1 para salir del programa): ");
			i = sc.nextByte();

			if (i > -1) {
				System.out.println(mes.insertaGrupo(i));
			} else {
				System.out.println("Gracias. Hasta pronto");
			} // Fin Si
		} while (i > -1);
	}// Fin Programa
}
