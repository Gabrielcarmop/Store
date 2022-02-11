package com.porto.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.porto.store.domain.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer > {

	@Query("SELECT obj FROM Produto obj WHERE obj.cliente.id = :id_cat ORDER BY nome")
	List<Produto> findAllByCliente(@Param(value = "id_cat")Integer id_cat);

}
