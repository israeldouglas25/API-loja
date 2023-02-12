package br.com.loja.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.loja.dto.ItemPedidoDTO;
import br.com.loja.exception.EntidadeNaoEncontradaException;
import br.com.loja.model.ItemPedido;
import br.com.loja.model.Produto;
import br.com.loja.repository.ItemPedidoRepository;
import br.com.loja.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemPedidoService {
	
	private ProdutoRepository produtoRepository;
	private ItemPedidoRepository itemPedidoRepository;
	
	@Transactional
	public ItemPedidoDTO save(ItemPedido item) {
		Produto saveProduto = produtoRepository.findById(item.getProduto().getId())
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado!"));
		
		item.setProduto(saveProduto);
		ItemPedido saved = itemPedidoRepository.save(item);
		return ItemPedidoDTO.of(saved);
	}

}
