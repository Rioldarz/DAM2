package com.miguelangel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelangel.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

}
