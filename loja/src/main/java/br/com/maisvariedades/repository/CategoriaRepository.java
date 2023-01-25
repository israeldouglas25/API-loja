package br.com.maisvariedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maisvariedades.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
