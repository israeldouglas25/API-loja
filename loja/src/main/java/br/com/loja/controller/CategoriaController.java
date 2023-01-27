package br.com.loja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.model.Categoria;
import br.com.loja.service.CategoriaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaService categoriaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.ok(categoriaService.save(categoria));
	}
		
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok(categoriaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		return ResponseEntity.ok(categoriaService.findById(id));
	}
	
	@GetMapping("/nome")
	public ResponseEntity<Categoria> findByNome(@RequestParam String nome){
		return ResponseEntity.ok(categoriaService.findByName(nome));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
