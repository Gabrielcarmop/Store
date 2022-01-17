package com.porto.store.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.store.domain.Cliente;
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
	
}
