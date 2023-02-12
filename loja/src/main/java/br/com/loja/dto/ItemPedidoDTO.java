package br.com.loja.dto;

import java.math.BigDecimal;

import br.com.loja.model.ItemPedido;
import br.com.loja.model.Pedido;
import br.com.loja.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoDTO {

	private Long id;
	private int qtdProduto;
	private BigDecimal precoUnitario;
	private Produto produto;
	private Pedido pedido;

	public static ItemPedidoDTO of(ItemPedido itemPedido) {
		ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
		itemPedidoDTO.setId(itemPedido.getId());
		itemPedidoDTO.setQtdProduto(itemPedido.getQtdProduto());
		itemPedidoDTO.setPrecoUnitario(itemPedido.getPrecoUnitario());
		itemPedidoDTO.setProduto(itemPedido.getProduto());
		itemPedidoDTO.setPedido(itemPedido.getPedido());

		return itemPedidoDTO;
	}

}
