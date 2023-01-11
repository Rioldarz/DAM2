package com.miguelangel.controller;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JasperController implements JRDataSource {

	private List<String[]> datosAMostrar;
	private int index;

	public JasperController() {
		// Entorno:
		// Algoritmo:
		this.index = -1;
		this.datosAMostrar = HumanoController.recoleccionListaDatos(HumanoController.creadorInicial());
	}//Fin Constrcutor

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		return false;
	}

}
