package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
