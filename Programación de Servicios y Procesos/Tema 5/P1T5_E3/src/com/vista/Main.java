package com.vista;

import com.modelo.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// Entorno:
		Atleta a1, a2, a3, a4, a5, a6, a7, a8;
		final Carrera1 ct = new Carrera1();
		final Carrera2 ct2 = new Carrera2();

		// Algoritmo:
		a1 = new Atleta("Josemi", (byte) 1);
		a2 = new Atleta("Jose Antonio", (byte) 2);
		a3 = new Atleta("Luis", (byte) 3);
		a4 = new Atleta("Dani", (byte) 4);
		a5 = new Atleta("Jesus", (byte) 5);
		a6 = new Atleta("Sarah", (byte) 6);
		a7 = new Atleta("Carlos", (byte) 7);
		a8 = new Atleta("Alfredo", (byte) 8);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ct.carrera("1", a1, a2, a3, a4);
				} catch (InterruptedException ie) {
					System.out.println(ie.getMessage());
				} // Fin try
			}// Fin Procedimiento
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ct.cambiarJugador();
				} catch (InterruptedException ie) {
					System.out.println(ie.getMessage());
				} // Fin try
			}// Fin Procedimiento
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ct2.carrera2("2", a5, a6, a7, a8);
				} catch (InterruptedException ie) {
					System.out.println(ie.getMessage());
				} // Fin try
			}// Fin Procedimiento
		});

		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ct2.cambiarJugador2();
				} catch (InterruptedException ie) {
					System.out.println(ie.getMessage());
				} // Fin try
			}// Fin Procedimiento
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();
	}// Fin Programa

}
