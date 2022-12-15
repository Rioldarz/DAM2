package com.pruebas;

import java.text.ParseException;
import java.util.LinkedList;

import com.controller.VideojuegoController;
import com.model.Videojuego;

public class Tests {
	
	public static void main(String[] args) throws ParseException {
		Videojuego vj;
		LinkedList<Videojuego> vjs = new LinkedList<Videojuego>();
		VideojuegoController controlador = new VideojuegoController();

//		vj = new Videojuego("Hollow Knight", "24-02-2017", "Metroidvania", 24.99F);
//		vjs.add(vj);
//		
//		vj = new Videojuego("Cuphead", "29-09-2017", "Accion", 24.99F);
//		vjs.add(vj);
//
//		controlador.createVideojuegos(vjs);
//		controlador.deleteVideojuego("Hollow Knight");
//		controlador.deleteVideojuego("Cuphead");
//		controlador.buscaVideojuego("Dead Cells");
//		controlador.buscaVideojuego("Josemi");
//		controlador.mostrarTodos();
//		controlador.deleteVideojuegos();
		
//		vj = new Videojuego("Hollow Knight", "24-02-2017", "Metroidvania", 24.99F);
//		vjs.add(vj);
//		controlador.createVideojuegos(vjs);
		
		vj = new Videojuego("Hollow Knight (Switch)", "24-02-2019", "Metroidvania", 24.99F);
		
		controlador.updateVideojuego("Hollow Knight", vj.datosSeparados());
	}

}
