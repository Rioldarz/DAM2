package com.vista;

import java.sql.Connection;

import com.connection.Conexion;

public class Prueba {

	public static void main(String[] args) {
		Conexion conn;
		conn = new Conexion();
		Connection reg = conn.getConnection();

		conn.desconectar();
	}// Fin Programa

}
