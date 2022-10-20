import java.io.IOException;
import java.util.Scanner;

public class EjemploVideo1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero1, numero2;

		System.out.print("Dame un nimero: ");
		numero1 = teclado.nextInt();
		System.out.print("Dame otro numero: ");
		numero2 = teclado.nextInt();

		try {
			int estado_ejecucion = ejecutarClaseProceso(Sumador.class, numero1, numero2);
			if (estado_ejecucion == 0) {
				System.out.println("Proceso ejecutado correctamente.");
			}else {
				System.out.println("Error ejecutando el proceso");
			}//Fin Si
		}catch (IOException | InterruptedException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		}//Fin try
	}
}