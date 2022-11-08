package com.modelo;

public class Djokovic extends Thread {
	public void run() {
		while (true) {
			System.out.println("¡¡Yuuuaaaa!!");
			Thread.yield();
			try {
				Thread.sleep(NORM_PRIORITY * 50);
			} catch (InterruptedException e) {
				System.out.println();
			} // Fin try
		} // Fin Mientras
	}// Fin Procedimiento
}
