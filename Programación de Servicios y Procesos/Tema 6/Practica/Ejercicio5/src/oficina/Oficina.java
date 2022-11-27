package oficina;

import java.util.Random;

public class Oficina {

	public static void main(String[] args) {
		Parado p1 = new Parado("Hilo 1");
		Puesto p2 = new Puesto("Hilo 2");
		p1.start();
		p2.start();
	}// Fin Programa

}

class Parado extends Thread {
	// Atributos:
	int numPersonas;
	Random r = new Random();
	boolean apuntandose;
	String n;

	// Constructores:
	public Parado(String nombre) {
		n = nombre;
	}// Fin Constructor

	// Métodos:
	public void run() {
		numPersonas = r.nextInt(100) + 1;
		for (int i = 1; i < numPersonas; i++) {
			System.out.println("Apuntandose a la lista la persona numero: " + i);
		} // Fin Para
	}// Fin Procedimiento
}

class Puesto extends Thread {
	// Atributos:
	Random r = new Random();
	int tiempo;
	String n;

	// Constructores
	public Puesto(String nombre) {
		n = nombre;
	}// Fin Constructor

	// Métodos:
	public void run() {
		tiempo = r.nextInt(100) + 1;
		try {
			for (int i = 1; i < tiempo; i++) {
				System.out.println("Realizando tramites...");
				sleep(tiempo);
			} // Fin Para

			int numPuestos;
			numPuestos = r.nextInt(50) + 1;

			for (int i = 1; i < numPuestos; i++) {
				System.out.println("Creando puesto...");
			} // Fin Para

		} catch (InterruptedException e) {
		} // Fin try
	}// Fin Procedimiento
}