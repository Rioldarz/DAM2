package com.miguelangel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelangel.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
