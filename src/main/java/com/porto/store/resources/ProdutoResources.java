package com.porto.store.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.porto.store.domain.Produto;
import com.porto.store.dtos.ProdutoDto;
import com.porto.store.service.ProdutoService;

@RestController
@RequestMapping(value="/Produtos")
public class ProdutoResources {
	
	@Autowired
	public ProdutoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping 
	public ResponseEntity<List<ProdutoDto>> findAll(@RequestParam(value = "cliente", defaultValue = "0") Integer id_cat){
		List<Produto> list = service.findAll(id_cat);
		List<ProdutoDto> listDto = list.stream().map(obj -> new ProdutoDto(obj)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@Valid @RequestBody Produto obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/livros/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update( @PathVariable Integer id,@Valid @RequestBody Produto obj){
		Produto newobj = service.update(id,obj);
		return ResponseEntity.ok().body(newobj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Produto> updatePatch(@PathVariable Integer id,@Valid @RequestBody Produto obj){
		Produto newobj = service.update(id,obj);
		return ResponseEntity.ok().body(newobj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
