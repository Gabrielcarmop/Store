package com.porto.store.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.store.domain.Cliente;
import com.porto.store.domain.Produto;
import com.porto.store.repositories.ClienteRepository;
import com.porto.store.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	public void instanciarBancoDeDados() {
		Cliente cli1 = new Cliente(null,"Mercado da Praça","99101075","Sandra Regina");
		Cliente cli2 = new Cliente(null,"Mercado dos meninos","99121235","Ouro Branco");
		Cliente cli3 = new Cliente(null,"Mercado ouro branco","99121175","Ouro Branco");

		Produto pro1 = new Produto(null,"Pizza Pequena",20,2.70,cli1);
		Produto pro2 = new Produto(null,"Pizza Media",20,3.70,cli1);
		Produto pro3 = new Produto(null,"Pizza Grande",6,14.0,cli1);
		Produto pro4 = new Produto(null,"Pizza Pequena",20,2.70,cli2);
		Produto pro5 = new Produto(null,"Pizza Media",20,3.70,cli3);
		
		cli1.getProduto().addAll(Arrays.asList(pro1, pro2, pro3));
		cli2.getProduto().addAll(Arrays.asList(pro4));
		cli3.getProduto().addAll(Arrays.asList(pro5));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
		produtoRepository.saveAll(Arrays.asList(pro1,pro2,pro3,pro4,pro5));
	}
}
