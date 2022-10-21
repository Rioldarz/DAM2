import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EjemploVideo1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero1, numero2;

		System.out.print("Dame un numero: ");
		numero1 = teclado.nextInt();
		System.out.print("Dame otro numero: ");
		numero2 = teclado.nextInt();

		try {
			int estado_ejecucion = ejecutarClaseProceso(Sumador.class, numero1, numero2);
			if (estado_ejecucion == 0) {
				System.out.println("Proceso ejecutado correctamente.");
			} else {
				System.out.println("Error ejecutando el proceso");
			} // Fin Si
		} catch (IOException | InterruptedException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		} // Fin try
	}// Fin Programa

	@SuppressWarnings("rawtypes")
	public static int ejecutarClaseProceso(Class clase, int n1, int n2) throws IOException, InterruptedException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separatorChar + "bin" + File.separatorChar + "java";

		String classPath = System.getProperty("java.class.path");
		String className = clase.getCanonicalName();

		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classPath, className, String.valueOf(n1),
				String.valueOf(n2));
		Process process = builder.start();
		
		process.waitFor();
		return process.exitValue();
	}//Fin Función
}