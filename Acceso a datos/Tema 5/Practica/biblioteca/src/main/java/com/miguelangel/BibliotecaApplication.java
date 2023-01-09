package com.miguelangel;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.miguelangel.model.Categoria;
import com.miguelangel.repository.CategoriasRepository;
import com.miguelangel.repository.LibrosRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private CategoriasRepository categoriasRepo;

	@Autowired
	private LibrosRepository librosRepo;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}// Fin Programa

	@Override
	public void run(String... args) throws Exception {
//		buscarTodosJpa();
		
		guardar();
		buscarPorId();
		modificarCategoria();
		eliminarCategoria();
		conteo();
		//Creo que explota a partir de aquí
		borrarTodoEnBloque();
		encontrarPorIds();
		buscarTodosJpa();
		existsId();
		guardarTodasCategorias();
		buscarTodasCategoriasOrdenadas();
		buscarTodosPorPaginacion();
		buscarTodosPorPaginacionOrdenados();
	}// Fin Procedimiento

//	private void buscarTodosJpa() {
//		List<Categoria> categorias = categoriasRepo.findAll();
//		for (Categoria c : categorias) {
//			System.out.println(c.getId() + " " + c.getNombre());
//		} // Fin Paras
//	}// Fin Procedimiento

	/*
	 * MÉTODOS CON CATEGORÍA
	 */
	private void guardar() {
		Categoria cat = new Categoria();
		cat.setNombre("Terror");
		cat.setDescripcion("Relatos que buscan ocasionar al lector sensaciones de miedo y de angustia");
		categoriasRepo.save(cat);
		System.out.println(cat);
	}// Fin Procedimiento

	private void buscarPorId() {
		Optional<Categoria> optional = categoriasRepo.findById(1);
		if (optional.isPresent() == true) {
			System.out.println(optional.get());
		} else {
			System.out.println("Categoría no encontrada");
		} // Fin Si
	}// Fin Procedimiento

	private void modificarCategoria() {
		Optional<Categoria> optional = categoriasRepo.findById(9);
		if (optional.isPresent() == true) {
			Categoria catTemp = optional.get();
			catTemp.setNombre("De terror");
			categoriasRepo.save(catTemp);
			System.out.println(optional.get());
		} else {
			System.out.println("Categoría no encontrada");
		} // Fin Si
	}// Fin Procedimiento

	private void eliminarCategoria() {
		int idCategoria = 9;
		categoriasRepo.deleteById(idCategoria);
	}// Fin Procedimiento

	private void conteo() {
		long count = categoriasRepo.count();
		System.out.println("Total categorías: " + count);
	}// Fin Procedimiento

	private void borrarTodoEnBloque() {
		categoriasRepo.deleteAllInBatch();
	}// Fin Procedimiento

	private void encontrarPorIds() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(9);
		Iterable<Categoria> categorias = categoriasRepo.findAllById(ids);
		for (Categoria cat : categorias) {
			System.out.println(cat);
		} // Fin Para
	}// Fin Procedimiento

	private void buscarTodosJpa() {
		List<Categoria> categorias = categoriasRepo.findAll();
		for(Categoria c: categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}//Fin Para
	}//Fin Procedimiento
	
	private void existsId() {
		boolean existe = categoriasRepo.existsById(5);
		System.out.println("La categoría existe: " + existe);
	}//Fin Procedimiento
	
	private void guardarTodasCategorias() {
//		List<Categoria> entities = getListaCategorias();
//		categoriasRepo.saveAll(entities);
	}//Fin Procedimiento
	
	private void buscarTodasCategoriasOrdenadas() {
		List<Categoria> categorias = categoriasRepo.findAll(Sort.by("nombre").descending());
		for(Categoria c: categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}//Fin Para
	}//Fin Procedimiento
	
	private void buscarTodosPorPaginacion() {
		Page<Categoria> page = categoriasRepo.findAll(PageRequest.of(0, 5));
		System.out.println("Total Registros: " + page.getTotalElements());
		System.out.println("Total Páginas: " + page.getTotalPages());
		for(Categoria c: page.getContent()) {
			System.out.println(c.getId() + " " + c.getNombre());
		}//Fin Para
	}//Fin Procedimiento
	
	private void buscarTodosPorPaginacionOrdenados() {
		Page<Categoria> page = categoriasRepo.findAll(PageRequest.of(0, 5, Sort.by("nombre")));
		System.out.println("Total Registros: " + page.getTotalElements());
		System.out.println("Total Páginas: " + page.getTotalPages());
		for(Categoria c: page.getContent()) {
			System.out.println(c.getId() + " " + c.getNombre());
		}//Fin Para
	}//Fin Procedimiento
}
