package br.com.loja.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.loja.dto.ProdutoDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal valor;

	private int qtd;

	@ManyToOne
	private Categoria categoria;

	public static Produto of(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setId(produtoDTO.getId());
		produto.setNome(produtoDTO.getNome());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setValor(produtoDTO.getValor());
		produto.setQtd(produtoDTO.getQtd());
		produto.setCategoria(produtoDTO.getCategoria());
		return produto;
	}

}