package com.main;

import java.util.Scanner;

import com.controller.ControllerCliente;
import com.model.Cliente;

public class Main {
	public static void menu() {
		System.out.println("¿Qué desea hacer?:");
		System.out.println("\t1. Dar de alta a usuario");
		System.out.println("\t2. Modificar usuario");
		System.out.println("\t3. Eliminar usuario");
		System.out.print("Opción: ");
	}// Fin Procedimiento
	
	public static Cliente buscarUsuario(String nombre) {
		Cliente cliente;
		ControllerCliente controller = new ControllerCliente();
		
		controller.verClientes();
	}

	public static void main(String[] args) {
		// Entorno:
		Cliente cliente;
		byte opc;
		Scanner sc = new Scanner(System.in);
		String datos;
		ControllerCliente controller = new ControllerCliente();

		// Algoritmo:
		menu();
		opc = sc.nextByte();

		switch (opc) {
		case 1:
			cliente = new Cliente();

			System.out.print("¿Qué nombre desea dar de alta?: ");
			datos = sc.next();
			cliente.setNombre(datos);

			System.out.print("¿Qué edad desea darle a " + cliente.getNombre() + "?: ");
			datos = sc.next();
			cliente.setEdad(Integer.parseInt(datos));
			
			System.out.print("¿Qué ciudad desea darle a " + cliente.getNombre() + "?: ");
			datos = sc.next();
			cliente.setCiudad(datos);
			
			System.out.print("¿Qué nombre de padre desea darle a " + cliente.getNombre() + "?: ");
			datos = sc.next();
			cliente.setPadre(datos);
			
			System.out.print("¿Qué nombre de madre desea darle a " + cliente.getNombre() + "?: ");
			datos = sc.next();
			cliente.setMadre(datos);
			
			controller.alta(cliente);
			break;
		case 2:
			cliente = new Cliente();
			
			System.out.print("¿A quién desea modificar? Nombre: ");
			datos = sc.next();
			
			cliente.setNombre(datos);
			
			//Seguir planteamiento
		case 3:
			cliente = new Cliente();
			
			System.out.print("¿A quién desea eliminar? Nombre: ");
			datos = sc.next();
			
			cliente.setNombre(datos);
			controller.eliminar(cliente);
		}
	}

}
