package com.vista;

import java.util.List;

import com.model.Cliente;

public class ViewCliente {

	/**
	 * @param cliente
	 */
	public void verCliente(Cliente cliente) {
		System.out.println("Datos del Cliente: " + cliente);
	}//Fin Procedimiento

	/**
	 * @param clientes
	 */
	public void verClientes(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println("Datos del Cliente: " + cliente);
		}//Fin Para
	}//Fin Procedimiento
	
	/**
	 * @param clientes
	 */
	public Cliente recogerClientes(List<Cliente> clientes) {
		Cliente salida
		
		for (Cliente cliente : clientes) {
			System.out.println("Datos del Cliente: " + cliente);
		}//Fin Para
	}//Fin Procedimiento
}
