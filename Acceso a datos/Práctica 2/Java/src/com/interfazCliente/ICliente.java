package com.interfazCliente;

import java.util.List;

import com.model.Cliente;

public interface ICliente {
	/**
	 * @param cliente
	 * @return boolean
	 */
	public boolean alta(Cliente cliente);

	/**
	 * @param cliente
	 * @return boolean
	 */
	public boolean modificar(Cliente cliente);

	/**
	 * @param cliente
	 * @return boolean
	 */
	public boolean eliminar(Cliente cliente);

	/**
	 * @return List
	 */
	public List<Cliente> obtener();
}// Fin Interfaz
