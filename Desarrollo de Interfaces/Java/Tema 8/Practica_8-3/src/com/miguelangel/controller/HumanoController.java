package com.miguelangel.controller;

import java.util.LinkedList;
import java.util.List;

import com.miguelangel.model.Humano;

public class HumanoController {
	public static List<Humano> creadorInicial(){
		//Entorno:
		Humano hijo, padre, madre;
		LinkedList<Humano> listaHums;
		
		//Algoritmo:
		hijo = new Humano("Nuria", "Fuentes Perez", "01-01-1950", "Hospital Macarena", "Mairena del Aljarafe, 1", "Sevilla", "Sevilla",  "666999666");
		padre = new Humano("Marco", "Polo Norte", "15-09-1254", "Casa su madre", "Venecia, 69", "Venecia", "Venecia",  "---------");
		madre = new Humano("Marco", "Polo Norte", "06-01-1412", "Casa su madre", "Orleans, 33", "Orleans", "Orleans",  "---------");
		
		listaHums = new LinkedList<Humano>();
		listaHums.add(hijo);
		listaHums.add(padre);
		listaHums.add(madre);
		
		return listaHums;
	}//Fin Función
	
	public static List<String[]> recoleccionListaDatos(List<Humano> listaHums){
		//Entorno:
		LinkedList<String[]> salida;
		String[] datosHumano;
		
		//Algoritmo:
		salida = new LinkedList<String[]>();
		
		for(Humano c: listaHums) {
			datosHumano = new String[8];
			
			datosHumano[0] = c.getNombre();
			datosHumano[1] = c.getApellidos();
			datosHumano[2] = c.getFecNac();
			datosHumano[3] = c.getLugarNac();
			datosHumano[4] = c.getDir();
			datosHumano[5] = c.getMunicipio();
			datosHumano[6] = c.getProv();
			datosHumano[7] = c.getTelf();
			
			salida.add(datosHumano);
		}//Fin Para
		
		return salida;
	}//Fin Función
}
