package com.modelo;

public class Nadal extends Thread {
	public void run() {
		while (true) {
			System.out.println("¡¡Jaaaaa!!");
			Thread.yield();
			try {
				Thread.sleep(NORM_PRIORITY * 50);
			} catch (InterruptedException e) {
				System.out.println();
			} // Fin try
		} // Fin Mientras
	}// Fin Procedimiento
}
