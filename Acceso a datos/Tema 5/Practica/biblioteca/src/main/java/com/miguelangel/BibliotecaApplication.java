package com.miguelangel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.miguelangel.model.Categoria;
import com.miguelangel.repository.CategoriasRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}//Fin Programa

	@Override
	public void run(String... args) throws Exception {
		buscarTodosJpa();
	}//Fin Procedimiento
	
	private void buscarTodosJpa(){
		List<Categoria> categorias = categoriasRepo.findAll();
		for (Categoria c: categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}//Fin Paras
	}//Fin Procedimiento

}
