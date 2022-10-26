package com.modelo;

public class GestionaRecargas {
	private int[] meses = {0,0,0,0,0,0,0,0,0,0,0,0};
	
	public GestionaRecargas() {}
	
	public int getMes(int mes) {
		return this.meses[mes];
	}
	
	public void setMes(int mes, String cant) {
		int temp = Integer.parseInt(cant);
		this.meses[mes] += temp;
	}
}
