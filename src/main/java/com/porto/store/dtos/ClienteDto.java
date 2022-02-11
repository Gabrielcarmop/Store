package com.porto.store.dtos;

import java.io.Serializable;

import com.porto.store.domain.Cliente;

public class ClienteDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String telefone;
	private String endereco;
	public ClienteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteDto(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
