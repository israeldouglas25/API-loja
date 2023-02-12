package br.com.loja.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

	private Long id;

	private String nome;
	private String descricao;
	
	@NotNull(message = "Valor obrigatório!")
	private BigDecimal valor;
	
	private int qtdEstoque;
	
	private Categoria categoria;

	public static ProdutoDTO of(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setId(produto.getId());
		produtoDTO.setNome(produto.getNome());
		produtoDTO.setDescricao(produto.getDescricao());
		produtoDTO.setValor(produto.getValor());
		produtoDTO.setQtdEstoque(produto.getQtdEstoque());
		produtoDTO.setCategoria(produto.getCategoria());
		
		return produtoDTO;
	}

}
