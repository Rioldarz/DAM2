package com.controlador;

import java.util.List;

public interface ICliente {
	public boolean alta(Cliente cliente);

	public boolean modificar(Cliente cliente);

	public boolean eliminar(Cliente cliente);

	public List<Cliente> obtener();
}// Fin Interfaz
