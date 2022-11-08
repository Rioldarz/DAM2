package com.controlador;

import java.util.Comparator;

import com.modelo.Atleta;

public class Sorter implements Comparator<Atleta> {

	@Override
	public int compare(Atleta o1, Atleta o2) {
		return o1.getSegundos() - o2.getSegundos();
	}

}
