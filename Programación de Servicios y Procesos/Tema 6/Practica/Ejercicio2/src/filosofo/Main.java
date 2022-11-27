package filosofo;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore[] tenedores = new Semaphore[5];

		for (int a = 0; a < 5; a++) {
			tenedores[a] = new Semaphore(1, true);
		} // Fin Para

		Filosofo f1 = new Filosofo(tenedores[4], tenedores[0], 5, 1, "Socrates");
		Filosofo f2 = new Filosofo(tenedores[0], tenedores[1], 1, 2, "Nietzsche");
		Filosofo f3 = new Filosofo(tenedores[1], tenedores[2], 2, 3, "Platon");
		Filosofo f4 = new Filosofo(tenedores[2], tenedores[3], 3, 4, "Aristoteles");
		Filosofo f5 = new Filosofo(tenedores[3], tenedores[4], 4, 5, "Pitagoras");

		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
	}// Fin Programa

}
