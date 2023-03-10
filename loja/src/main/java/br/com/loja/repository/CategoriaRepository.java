package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	Categoria findByNome(String nome);
}
