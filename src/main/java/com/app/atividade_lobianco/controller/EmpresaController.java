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

import com.app.atividade_lobianco.model.entity.Empresa;
import com.app.atividade_lobianco.service.EmpresaService;

@RestController
@RequestMapping("empresa/")
@CrossOrigin(origins = "*")
public class EmpresaController {
    private EmpresaService empresaService ;
    
        public EmpresaController(EmpresaService empresaService) {
            this.empresaService = empresaService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Empresa>> findAll() {
                List<Empresa> empresas = empresaService.findAll();
                return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Empresa> findById(@PathVariable("id") Long id) {
                Empresa empresa = empresaService.findById(id);
                return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
                Empresa empresaSalvo = empresaService.create(empresa);
                return new ResponseEntity<Empresa>(empresaSalvo, HttpStatus.CREATED);
        }
    
        @PutMapping("update/{id}")
        public ResponseEntity<Empresa> update(@PathVariable("id") Long id, @RequestBody Empresa empresa) {
                Empresa empresaEditado = empresaService.update(id, empresa);
                return new ResponseEntity<Empresa>(empresaEditado, HttpStatus.OK);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                empresaService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
