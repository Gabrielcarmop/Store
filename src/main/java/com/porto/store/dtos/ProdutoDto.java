package com.porto.store.dtos;

import java.io.Serializable;

import com.porto.store.domain.Produto;

public class ProdutoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	public ProdutoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProdutoDto(Produto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
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

	
	
	
}
