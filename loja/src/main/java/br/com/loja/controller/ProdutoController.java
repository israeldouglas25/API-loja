package br.com.loja.controller;

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

import br.com.loja.dto.ProdutoDTO;
import br.com.loja.model.Produto;
import br.com.loja.service.ProdutoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private ProdutoService produtoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO produtoDTO) {
		return ResponseEntity.ok(produtoService.save(Produto.of(produtoDTO)));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(){
		return ResponseEntity.ok(produtoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(produtoService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
		return ResponseEntity.ok(produtoService.update(id, Produto.of(produtoDTO)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
