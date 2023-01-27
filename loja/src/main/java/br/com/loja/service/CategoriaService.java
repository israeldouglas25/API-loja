package br.com.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.loja.exception.EntidadeNaoEncontradaException;
import br.com.loja.model.Categoria;
import br.com.loja.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoriaService {
	
	private CategoriaRepository categoriaRepository;
	
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	@Transactional
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Categoria não existe!"));
	}
	
	@Transactional
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	@Transactional
	public Categoria findByName(String nome) {
		return categoriaRepository.findByNome(nome);
	}

}
