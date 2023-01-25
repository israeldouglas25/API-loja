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

import br.com.maisvariedades.model.Categoria;
import br.com.maisvariedades.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("categorias")
public class CategoriaController {

	private CategoriaRepository categoriaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(categoriaRepository.save(categoria));
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		return ResponseEntity.ok(categoriaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado.")));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
		categoria.setId(id);
		return ResponseEntity.ok(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
