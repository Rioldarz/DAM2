package fibonacci;

import java.util.concurrent.Semaphore;

public class SucesionFibonacci extends Thread {
	// Atributos:
	private Semaphore sumar = null;
	private static int num1 = 0;
	private static int num2 = 1;
	private static int suma = 1, n;
	private static boolean sumando = false;

	// Constructor:
	public SucesionFibonacci(int n) {
		this.n = n;
	}// Fin Constructor

	// Métodos:
	public void run() {
		try {
			for (int i = 1; i < n + 1; i++) {
				sleep(300);
				System.out.println("El primer número es: " + num1);
				System.out.println("El segundo número es: " + num2);
				System.out.println("El elemento " + i + ": " + suma);
				suma = num1 + num2;
				num1 = num2;
				num2 = suma;
			} // Fin Para
		} catch (InterruptedException e) {
		} // Fin try
	}// Fin Procedimiento

	public class main extends SucesionFibonacci {

		public main(int n) {
			super(n);
		}// Fin Constructor

	}

	public static void main(String[] args) {
		SucesionFibonacci sf = new SucesionFibonacci(20);
		sf.start();
	}// Fin Programa
}