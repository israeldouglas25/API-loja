package br.com.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.loja.dto.ProdutoDTO;
import br.com.loja.exception.EntidadeNaoEncontradaException;
import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;
import br.com.loja.repository.CategoriaRepository;
import br.com.loja.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	private CategoriaRepository categoriaRepository;

	@Transactional
	public ProdutoDTO save(Produto produto) {
		Categoria saveCategoria = categoriaRepository.findById(produto.getCategoria().getId())
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Categoria não encontrada!"));

		produto.setCategoria(saveCategoria);
		Produto saved = produtoRepository.save(produto);
		return ProdutoDTO.of(saved);
	}
	
	@Transactional
	public List<ProdutoDTO> findAll() {
		return produtoRepository.findAll()
				.stream()
				.map(ProdutoDTO::of)
				.toList();
	}
	
	@Transactional
	public ProdutoDTO findById(Long id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado!"));
		return ProdutoDTO.of(produto);
	}
	
	@Transactional
	public ProdutoDTO update(Long id, Produto produto) {
		findById(id);
		save(produto);
		return ProdutoDTO.of(produto);
	}

	@Transactional
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}

}
