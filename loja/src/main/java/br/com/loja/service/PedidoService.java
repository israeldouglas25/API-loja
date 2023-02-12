package br.com.loja.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.loja.dto.PedidoDTO;
import br.com.loja.model.ItemPedido;
import br.com.loja.model.Pedido;
import br.com.loja.repository.PedidoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PedidoService {
	
	private PedidoRepository pedidoRepository;
	
	public PedidoDTO save(Pedido pedido, ItemPedido itemPedido) {
		//ItemPedido itemPedido = new ItemPedido();
		
		pedido.setData(LocalDateTime.now());
		pedido.adicionarItem();
		
		Pedido saved = pedidoRepository.save(pedido);
		
		return PedidoDTO.of(saved);
	}

}
