package com.porto.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.store.domain.Cliente;
import com.porto.store.dtos.ClienteDto;
import com.porto.store.exceptions.ObjectNotFoundException;
import com.porto.store.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired 
	private ClienteRepository repository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj= repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id+", Tipo: "+ Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente create(Cliente obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Cliente update(Integer id,ClienteDto objDto) {
		Cliente obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setEndereco(objDto.getEndereco());
		obj.setTelefone(objDto.getTelefone());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
