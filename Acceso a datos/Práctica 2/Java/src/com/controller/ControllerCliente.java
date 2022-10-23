package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.implementaCliente.ImplementaICliente;
import com.interfazCliente.ICliente;
import com.model.Cliente;
import com.vista.ViewCliente;

/**
 * @author Miguel Angel
 *
 */
public class ControllerCliente {
	// Atributos
	private ViewCliente vista = new ViewCliente();

	// Constructor
	public ControllerCliente() {
	}// Fin Constructor

	// Métodos
	/**
	 * @param cliente Llama a la implementación para crear al cliente
	 */
	public void alta(Cliente cliente) {
		ICliente dao = new ImplementaICliente();
		dao.alta(cliente);
	}// Fin Procedimiento

	/**
	 * @param cliente Llama a la implementación para modificar un cliente
	 */
	public void modificar(Cliente cliente) {
		ICliente dao = new ImplementaICliente();
		dao.modificar(cliente);
	}// Fin Procedimiento

	/**
	 * @param cliente Llama a la implementación para eliminar un cliente
	 */
	public void eliminar(Cliente cliente) {
		ICliente dao = new ImplementaICliente();
		dao.eliminar(cliente);
	}// Fin Procedimiento

	/**
	 * Llama a la implementación para obtener todos los clientes y luego los muestra
	 * en la vista
	 */
	public void verClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ICliente dao = new ImplementaICliente();
		clientes = dao.obtener();
		vista.verClientes(clientes);
	}// Fin Procedimiento
	
	public List<Cliente> recogerClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ICliente dao = new ImplementaICliente();
		clientes = dao.obtener();
		
		return clientes;
	}// Fin Procedimiento
}
