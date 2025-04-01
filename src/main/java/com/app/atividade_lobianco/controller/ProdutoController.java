package com.app.atividade_lobianco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.atividade_lobianco.model.entity.Produto;
import com.app.atividade_lobianco.service.ProdutoService;

@RestController
@RequestMapping("produto/")
@CrossOrigin(origins = "*")
public class ProdutoController {
    private ProdutoService produtoService ;
    
        public ProdutoController(ProdutoService produtoService) {
            this.produtoService = produtoService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Produto>> findAll() {
                List<Produto> produtos = produtoService.findAll();
                return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Produto> findById(@PathVariable("id") Long id) {
                Produto produto = produtoService.findById(id);
                return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Produto> create(@RequestBody Produto produto) {
                Produto produtoSalvo = produtoService.create(produto);
                return new ResponseEntity<Produto>(produtoSalvo, HttpStatus.CREATED);
        }
    
        @PutMapping("update/{id}")
        public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody Produto produto) {
                Produto produtoEditado = produtoService.update(id, produto);
                return new ResponseEntity<Produto>(produtoEditado, HttpStatus.OK);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                produtoService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
