package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
