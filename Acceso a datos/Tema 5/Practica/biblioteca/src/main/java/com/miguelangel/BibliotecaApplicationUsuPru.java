package com.miguelangel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.miguelangel.model.Perfil;
import com.miguelangel.repository.CategoriasRepository;

@SpringBootApplication
public class BibliotecaApplicationUsuPru implements CommandLineRunner {

	@Autowired
	private CategoriasRepository categoriasRepo;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplicationUsuPru.class, args);
	}// Fin Programa

	@Override
	public void run(String... args) throws Exception {
	}// Fin Procedimiento

	public void agregar(Perfil tempPerfil) {
		
	}
}
