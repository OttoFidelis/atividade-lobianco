package com.app.atividade_lobianco.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.atividade_lobianco.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
