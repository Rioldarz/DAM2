package com.vista;

import com.modelo.Carrera;

public class Main {

	public static void main(String[] args) {
		// Entorno:
		Carrera corrida;

		// Algoritmo:
		corrida = new Carrera();

		if (corrida.salida()) {
			System.out.println("¡Se ha dado el pistoletazo de salida!");
		} // Fin Si

		System.out.println("¡Y ya han llegado!:");
//		corrida.llegadas();
		corrida.resultado();
	}

}
