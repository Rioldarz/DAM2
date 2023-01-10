package com.miguelangel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.miguelangel.model.Categoria;
import com.miguelangel.model.Libro;
import com.miguelangel.repository.CategoriasRepository;
import com.miguelangel.repository.LibrosRepository;

@SpringBootApplication
public class BibliotecaApplicationLibPru implements CommandLineRunner {

	@Autowired
	private CategoriasRepository categoriasRepo;

	@Autowired
	private LibrosRepository librosRepo;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplicationLibPru.class, args);
	}// Fin Programa

	@Override
	public void run(String... args) throws Exception {
		guardarLibro();
	}// Fin Procedimiento

	/*
	 * Métodos de libro
	 */

	private void guardarLibro() {
		Libro libro = new Libro();
		libro.setTitulo("Historias de fantasmas");
		libro.setAutor("LAURA FREUDENTHALER");
		libro.setFecha(new Date());
		libro.setPrecio(14.15);
		libro.setDisponibilidad("Disponible");
		libro.setDestacado(1);
		libro.setImagen("fantasma.png");
		libro.setDescripcion(
				"<h1>Un retrato sutil de un inquietante triángulo amoroso. Anne pensaba dedicar su año sabático a tocar el piano y escribir libros, pero paulatinamente abandona sus hábitos.</h1>");
		Categoria cat = new Categoria();
		cat.setId(1);
		libro.setCategoria(cat);
		librosRepo.save(libro);
	}// Fin Procedimiento
}
