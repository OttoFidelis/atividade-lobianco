package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.atividade_lobianco.model.entity.Produto;
import com.app.atividade_lobianco.model.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            Produto _produto = produto.get();
            return _produto;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar o produto");
    }
    @Transactional
    public List<Produto> findAll() {
            List<Produto> produtos = produtoRepository.findAll();
            return produtos;
    }
    @Transactional
    public Produto create(Produto produto) {
            Produto produtoSalvo = produtoRepository.save(produto);
            return produtoSalvo;
    }

    @Transactional
    public void delete(long id) {
            produtoRepository.deleteById(id);
    }

    @Transactional
    public Produto update(Long id, Produto produto) {
        Optional<Produto> _produto = produtoRepository.findById(id);
        if (_produto.isPresent()) {
            Produto produtoUpdate = _produto.get();
            produtoUpdate.setFoto(produto.getFoto());
            return produtoUpdate;
        } else
            throw new RuntimeException("Ocorreu um erro ao editar o produto");
    }
}
