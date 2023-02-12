package br.com.loja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.loja.dto.ItemPedidoDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private int qtdProduto;

	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	public static ItemPedido of(ItemPedidoDTO itemPedidoDTO) {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setId(itemPedidoDTO.getId());
		itemPedido.setQtdProduto(itemPedidoDTO.getQtdProduto());
		itemPedido.setPrecoUnitario(itemPedidoDTO.getPrecoUnitario());
		itemPedido.setProduto(itemPedidoDTO.getProduto());
		itemPedido.setPedido(itemPedidoDTO.getPedido());

		return itemPedido;
	}

	public BigDecimal getValor() {
		return precoUnitario.multiply(new BigDecimal(qtdProduto));
	}

}
