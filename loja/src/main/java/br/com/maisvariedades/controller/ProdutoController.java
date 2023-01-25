package br.com.maisvariedades.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.maisvariedades.model.Produto;
import br.com.maisvariedades.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("produtos")
public class ProdutoController {

	private ProdutoRepository produtoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoRepository.save(produto));
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		return ResponseEntity.ok(produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado.")));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
		produto.setId(id);
		return ResponseEntity.ok(produtoRepository.save(produto));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
