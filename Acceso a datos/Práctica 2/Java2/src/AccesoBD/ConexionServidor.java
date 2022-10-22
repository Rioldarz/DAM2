package AccesoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionServidor {
	// Atributos:
	private Connection conn;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String usuario = "user";
	private final String contrasenia = "test";
	private final String url = "jdbc:mysql://192.168.1.34:8000/Practica2";

	// Constructor:
	/*
	 * El constructor se encarga de usar el driver y hacer la conexión a la bd
	 */
	public ConexionServidor() {
		this.conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, contrasenia);
			if (conn != null) {
				System.out.println("Conexión establecida..");
			}//Fin Si
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println("Error al conectar..");
		}//Fin try
	}//Fin Constructor
	
	//Métodos:
	/*
	 * Este método devuelve la conexión
	 */
	public Connection getConnection() {
		return this.conn;
	}//Fin Función
	
	/*
	 * Este método desconecta de la bd
	 */
	public void desconectar() {
		this.conn = null;
		if (this.conn == null) {
			System.out.println("Conexión terminada..");
		}//Fin Si
	}//Fin Procedimiento
}
