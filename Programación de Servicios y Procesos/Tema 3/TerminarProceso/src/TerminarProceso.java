import java.io.IOException;
import java.util.Scanner;

public class TerminarProceso {

	public static void main(String[] args) {
		String RUTA_PROCESO = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
		ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
		Scanner teclado = new Scanner(System.in);

		try {
			Process process = pb.start();
			System.out.print("¿Terminar el proceso? (S/N): ");
			if (teclado.nextLine().charAt(0) == 'S') {
				process.destroy();
			} // Fin Si
		} catch (IOException ioe) {
			System.err.println("Error: " + ioe.toString());
			System.exit(-1);
		} // Fin try
	}// Fin Programa

}
