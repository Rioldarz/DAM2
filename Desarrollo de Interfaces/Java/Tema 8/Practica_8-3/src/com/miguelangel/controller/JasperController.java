package com.miguelangel.controller;

import java.util.List;

import com.miguelangel.model.Humano;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JasperController implements JRDataSource {

//	private final Object[][] listadoHumanos;
//	private List<String[]> datosAMostrar;
	private List<Humano> listaHumanos;
	private int index;

	public JasperController() {
		// Entorno:
		// Algoritmo:
		this.index = -1;
//		this.datosAMostrar = HumanoController.recoleccionListaDatos(HumanoController.creadorInicial());
		this.listaHumanos = HumanoController.creadorInicial();
		
//		this.listadoHumanos = new Object[][] {
//			this.datosAMostrar.get(0), this.datosAMostrar.get(1), this.datosAMostrar.get(2)
//		};
	}//Fin Constrcutor

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {

		Object value = null;
		
		String fieldName = arg0.getName();
		
		switch(fieldName) {
		case "nombre":
//			value = this.listadoHumanos[this.index][0];
			String[] listadoHumanos = new String[]{
				this.listaHumanos.get(0).getNombre(), this.listaHumanos.get(1).getNombre(),
				this.listaHumanos.get(2).getNombre()
			};
			
			
			value = listadoHumanos;
			break;
//		case "apellidos":
//			value = this.listadoHumanos[this.index][1];
//			break;
//		case "fecNac":
//			value = this.listadoHumanos[this.index][2];
//			break;
//		case "lugarNac":
//			value = this.listadoHumanos[this.index][3];
//			break;
//		case "dir":
//			value = this.listadoHumanos[this.index][4];
//			break;
//		case "municipio":
//			value = this.listadoHumanos[this.index][5];
//			break;
//		case "prov":
//			value = this.listadoHumanos[this.index][6];
//			break;
//		case "telf":
//			value = this.listadoHumanos[this.index][7];
//			break;
		}//Fin Según Sea
		
		return value;
	}//Fin Función

	@Override
	public boolean next() throws JRException {
//		this.index++;
//		return (this.index < datosAMostrar.size());
		return false;
	}//Fin Función
	
	public static JRDataSource getDataSource() {
		return new JasperController();
	}//Fin Función

}
