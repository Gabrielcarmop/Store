package com.porto.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.store.domain.Produto;
import com.porto.store.dtos.ProdutoDto;
import com.porto.store.exceptions.ObjectNotFoundException;
import com.porto.store.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	public ProdutoRepository repository;
	
	@Autowired 
	public ClienteService  clienteService;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj= repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id+", Tipo: "+ Produto.class.getName()));
	}
	
	public List<Produto> findAll(Integer id_cat) {
		clienteService.findAll();
		return repository.findAllByCliente(id_cat);
	}
	
	public Produto create(Produto obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Produto update(Integer id,Produto obj) {
		Produto newobj = findById(id);
		updateData(newobj, obj);
		return repository.save(newobj);
	}
	
	private void updateData(Produto newobj, Produto obj) {
		newobj.setNome(obj.getNome());
		newobj.setQuantidade(obj.getQuantidade());
		newobj.setValor(obj.getValor());		
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
