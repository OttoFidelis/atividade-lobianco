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

import com.app.atividade_lobianco.model.entity.Atendimento;
import com.app.atividade_lobianco.service.AtendimentoService;

@RestController
@RequestMapping("atendimento/")
@CrossOrigin(origins = "*")
public class AtendimentoController {
    
        private AtendimentoService atendimentoService ;
    
        public AtendimentoController(AtendimentoService atendimentoService) {
            this.atendimentoService = atendimentoService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Atendimento>> findAll() {
                List<Atendimento> atendimentos = atendimentoService.findAll();
                return new ResponseEntity<List<Atendimento>>(atendimentos, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Atendimento> findById(@PathVariable("id") Long id) {
                Atendimento atendimento = atendimentoService.findById(id);
                return new ResponseEntity<Atendimento>(atendimento, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Atendimento> create(@RequestBody Atendimento atendimento) {
                Atendimento atendimentoSalvo = atendimentoService.create(atendimento);
                return new ResponseEntity<Atendimento>(atendimentoSalvo, HttpStatus.CREATED);
        }
    
        @PutMapping("update/{id}")
        public ResponseEntity<Atendimento> update(@PathVariable("id") Long id, @RequestBody Atendimento atendimento) {
                Atendimento atendimentoEditado = atendimentoService.update(id, atendimento);
                return new ResponseEntity<Atendimento>(atendimentoEditado, HttpStatus.OK);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                atendimentoService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
