package com.controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modelo.Conexion;

public class ImplementaICliente implements ICliente {

	@Override
	public boolean alta(Cliente cliente) {
		boolean alta = false;

		Statement stm = null;
		Connection con = null;

		String sql = "INSERT INTO practica2 values('" + cliente.getNombre() + "'," + cliente.getEdad() + ",'"
				+ cliente.getCiudad() + "','" + cliente.getPadre() + "','" + cliente.getMadre() + "');";

		try {
			con = new Conexion().getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			alta = true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ImplementaICliente, método registrar");
			e.printStackTrace();
		} // Fin try

		return alta;
	}// Fin Función

	@Override
	public boolean modificar(Cliente cliente) {
		Connection connect = null;
		Statement stm = null;

		boolean modificar = false;

		String sql = "UPDATE PRACTICA2 SET edad=" + cliente.getEdad() + ",ciudad='" + cliente.getCiudad() + "',padre='"
				+ cliente.getMadre() + "'" + " WHERE nombre='" + cliente.getNombre() + "';";

		try {
			connect = new Conexion().getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
			modificar = true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ImplementaICliente, método actualizar");
			e.printStackTrace();
		} // Fin try

		return modificar;
	}// Fin Función

	@Override
	public boolean eliminar(Cliente cliente) {
		Connection connect = null;
		Statement stm = null;

		boolean eliminar = false;

		String sql = "DELETE FROM PRACTICA2 WHERE NOMBRE='" + cliente.getNombre() + "';";
		try {
			connect = new Conexion().getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
			eliminar = true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ImplementaICliente, método eliminar");
			e.printStackTrace();
		} // Fin try

		return eliminar;
	}// Fin Función

	@Override
	public List<Cliente> obtener() {
		Connection co = null;
		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM PRACTICA2 ORDER BY NOMBRE;";

		List<Cliente> lista = new ArrayList<Cliente>();

		try {
			co = new Conexion().getConnection();
			stm = co.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setNombre(rs.getString(1));
				c.setEdad(rs.getInt(2));
				c.setCiudad(rs.getString(3));
				c.setPadre(rs.getString(4));
				c.setMadre(rs.getString(5));
				lista.add(c);
			} // Fin Mientras
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ImplementaICliente, método obtener");
			e.printStackTrace();
		} // Fin try

		return lista;
	}// Fin Función

}
