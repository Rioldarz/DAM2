package com.modelo;

public class Atleta extends Thread {
	private int dorsal;
	
	public Atleta(int num) {
		this.dorsal = num;
	}
	
	public int getDorsal() {
		return dorsal;
	}

	public void run() {
		while (true) {
//			System.out.println("¡¡Yuuuaaaa!!");
			Thread.yield();
			try {
				Thread.sleep(NORM_PRIORITY * 50);
			} catch (InterruptedException e) {
				System.out.println();
			} // Fin try
		} // Fin Mientras
	}// Fin Procedimiento
}
