package br.com.loja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	public ItemPedido(int qtdProduto, Produto produto, Pedido pedido) {
		super();
		this.qtdProduto = qtdProduto;
		this.produto = produto;
		this.pedido = pedido;
		this.precoUnitario = produto.getValor();
	}

	public BigDecimal getValor() {
		return precoUnitario.multiply(new BigDecimal(qtdProduto));
	}

}
