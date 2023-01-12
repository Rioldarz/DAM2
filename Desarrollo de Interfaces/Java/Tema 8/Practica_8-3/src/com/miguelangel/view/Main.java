package com.miguelangel.view;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.WindowConstants;

import com.miguelangel.controller.JasperController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Main {

//	public Main() {
//		
//		Path filePath = Paths.get("./src/com/miguelangel/reports/Leaf_Violet.jasper");
//
//
//		try {
//			JasperReport report = (JasperReport) JRLoader
//					.loadObject(getClass().getResource(String.valueOf("./src/com/miguelangel/reports/Leaf_Violet.jasper")));
//			JasperPrint jPrint = JasperFillManager.fillReport(report, null, JasperController.getDataSource());
//
//			JasperViewer view = new JasperViewer(jPrint, false);
//			view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//			view.setVisible(true);
//		} catch (JRException ex) {
//			ex.getMessage();
//		}//Fin try
//		
//	}

	public static void main(String[] args) {
		// Entorno:

		// Algoritmo:
		Path filePath = Paths.get("./src/com/miguelangel/reports/Leaf_Violet.jasper");
		System.err.println(filePath);
//		Main jasper = new Main();
	}

}
