package com.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection conn;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String user = "user";
	private static final String password = "test";
	private static final String url = "jdbc:mysql://192.168.1.34:3306/myDb";

	// Este constructor crea y hace la conexión
	public Conexion() {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Conexion establecida..");
			} // Fin Si
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("Error al conectar " + ex);
		} // Fin try
	}// Fin Constructor

	// Este método devuelve la conexión
	public Connection getConnection() {
		return conn;
	}// Fin Funcion

	// Este método desconecta
	public void desconectar() {
		conn = null;
		if (conn == null) {
			System.out.println("Conexión terminada..");
		} // Fin Si
	}// Fin Procedimiento
}
