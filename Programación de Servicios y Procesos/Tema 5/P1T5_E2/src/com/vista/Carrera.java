package com.vista;

import java.util.ArrayList;

import com.modelo.Atleta;

public class Carrera {

	public static void main(String[] args) {
		ArrayList<Atleta> atleta = new ArrayList<>(8);

		for (int i = 1; i <= 8; i++) {
			atleta.add(new Atleta(i));
		}//Fin Para
		
	}

}
