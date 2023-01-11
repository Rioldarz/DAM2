package com.miguelangel.view;

import java.util.List;

import com.miguelangel.controller.HumanoController;

public class Main {

	public static void main(String[] args) {
		//Entorno:
		HumanoController controlador;
		List<String[]> datosAMostrar;
		
		//Algoritmo:
		controlador = new HumanoController();
		datosAMostrar = controlador.recoleccionListaDatos(controlador.creadorInicial());
		
		
	}

}
