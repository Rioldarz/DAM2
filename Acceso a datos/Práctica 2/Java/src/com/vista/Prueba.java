package com.vista;

import java.sql.Connection;

import com.modelo.Conexion;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion conn;
		conn = new Conexion();
		Connection reg = conn.getConnection();
		
		conn.desconectar();
	}//Fin Programa

}
