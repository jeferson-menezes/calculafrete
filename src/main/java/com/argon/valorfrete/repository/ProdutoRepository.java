package com.argon.valorfrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argon.valorfrete.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
