package filosofo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {
	// Atributos:
	private Semaphore teneDior;
	private Semaphore teneFerrero;
	private int posicionDior = -1;
	private int posicionFerrero = -1;
	private String nombre;
	private static Random r = new Random();

	// Constructores:
	public Filosofo(Semaphore cubiertod, Semaphore cubiertoi, int posicionDior, int posicionFerrero, String nombre) {
		this.teneDior = cubiertod;
		this.teneFerrero = cubiertoi;
		this.posicionDior = posicionDior;
		this.posicionFerrero = posicionFerrero;
		this.nombre = nombre;
	}// Fin Constructor

	private void pensar() {
		try {
			System.out.println("Esta pensando el filosofo: " + this.nombre);
			sleep(5000);
		} catch (InterruptedException e) {
		} // Fin try
	}// Fin Procedimiento

	private void comer() {
		try {
			teneDior.acquire();
			if (!teneFerrero.tryAcquire()) {
				teneDior.release();
				System.out.println(this.nombre + " tiene hambre porque no podia comer.");
			} // Fin Si

			System.out
					.println(this.nombre + " esta comiendo con el tenedor: " + this.posicionDior + " y " + this.posicionFerrero);
			sleep(r.nextInt(4000));
			System.out.println(this.nombre + " termino de comer por lo que suelta los tenedores: " + this.posicionDior
					+ " y " + this.posicionFerrero);
			teneFerrero.release();
			teneDior.acquire();
		} catch (InterruptedException e) {
		} // Fin try
	}// Fin Procedimiento

	@Override
	public void run() {
		while (true) {
			pensar();
			comer();
		} // Fin Mientras
	}// Fin Procedimiento

}
