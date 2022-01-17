package com.porto.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porto.store.domain.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer > {

}
