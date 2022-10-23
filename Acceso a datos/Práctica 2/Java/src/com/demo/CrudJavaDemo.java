package com.demo;

import com.controller.ControllerCliente;
import com.model.Cliente;

public class CrudJavaDemo {

	public static void main(String[] args) {
		// Entorno:
		Cliente cliente = new Cliente("Romeo Santos", 23, "Sevilla", "José Antonio", "Margarita");

		// Algoritmo
		// Crear al controlador
		ControllerCliente controller = new ControllerCliente();

		// Crear cliente por medio del controlador
		controller.alta(cliente);

		// Ver a todos los clientes por medio del controlador
		controller.verClientes();

		// Editar cliente por medio del controlador según su nombre
		cliente.setNombre("Romeo Santos");
		cliente.setEdad(32);
		controller.modificar(cliente);

		// Ver a todos los clientes por medio del controlador
		controller.verClientes();

		// Eliminar cliente por medio del controlador según su nombre
		cliente.setNombre("Romeo Santos");
		controller.eliminar(cliente);
	}// Fin Programa
}
