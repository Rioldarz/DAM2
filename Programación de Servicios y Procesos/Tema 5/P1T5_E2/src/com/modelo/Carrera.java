package com.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Carrera {
	// Atributos:
	ArrayList<Atleta> atletas;

	// Constructores:
	public Carrera() {
		this.atletas = new ArrayList<>(8);
		for (int i = 1; i <= 8; i++) {
			this.atletas.add(new Atleta((byte) i));
		} // Fin Para
	}

	// Métodos:
	public boolean salida() {
		for (Atleta a : this.atletas) {
			a.start();
		} // Fin Para

		return true;
	}// Fin Función

	public void llegadas() {
		Random llegadasAlatorias = new Random();
		LinkedList<Byte> llegadasEfectuadas = new LinkedList<>();
		
		byte temp = (byte) (llegadasAlatorias.nextInt(7)+1);
		this.atletas.get(temp).notifica();
		llegadasEfectuadas.add(temp);
		
		boolean salida = true;
		for (int i = 0; i < 7; i++) {
			do {
				salida = true;
				temp = (byte) (llegadasAlatorias.nextInt(7)+1);
				for(byte num: llegadasEfectuadas) {
					if (num == temp) {
						salida = false;
						break;
					}//Fin Si
				}//Fin Para
			} while (!salida);
			this.atletas.get(temp).notifica();
		}//Fin Para
	}//Fin Procedimiento

	public void resultado() {
		ordenar();
		System.out.println(this.toString());
	}// Fin Procedimiento

	private void ordenar() {
		Collections.sort(this.atletas, (o1, o2) -> o1.getSegundos() - o2.getSegundos());
	}// Fin Procedimiento

	@Override
	public String toString() {
		String salida = "";
		for (Atleta temp : this.atletas) {
			salida += temp.toString();
		} // Fin Para

		return salida;
	}// Fin Función
}
