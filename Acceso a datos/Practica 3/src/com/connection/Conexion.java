package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Miguel Angel Rodriguez Dali
 *
 */
public class Conexion {
	// Atributos:
	private static Connection conn;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private String user, password, url;

	// Constructores:
	// Este constructor crea y hace la conexión
	public Conexion() {
		conn = null;
		try {
			Class.forName(driver);
			
			AccesoProperties ap = new AccesoProperties();
			this.user = ap.usuario;
			this.password = ap.contrasenia;
			this.url = ap.url;
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("Error al conectar " + ex);
		} // Fin try
	}// Fin Constructor

	// Métodos
	public void asignaConexion() {
		AccesoProperties ap = new AccesoProperties();
		
	}
	
	// Este método devuelve la conexión
	/**
	 * @return Connection
	 */
	public Connection getConnection() {
		return this.conn;
	}// Fin Funcion

	// Este método desconecta
	public void desconectar() {
		conn = null;
		if (conn == null) {
			System.out.println("Conexión terminada..");
		} // Fin Si
	}// Fin Procedimiento
}
