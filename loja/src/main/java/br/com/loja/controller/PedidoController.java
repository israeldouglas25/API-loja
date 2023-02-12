package br.com.loja.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.model.ItemPedido;
import br.com.loja.model.Pedido;
import br.com.loja.repository.PedidoRepository;
import br.com.loja.service.ItemPedidoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	private PedidoRepository pedidoRepository;
	private ItemPedidoService itemPedidoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){			
		
		ItemPedido item = new ItemPedido();
		itemPedidoService.save(item);
		
		pedido.setData(LocalDateTime.now());
		pedido.adicionarItem(item);
		
		return ResponseEntity.ok(pedidoRepository.save(pedido));
	}

}
