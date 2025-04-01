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

import com.app.atividade_lobianco.model.entity.Propaganda;
import com.app.atividade_lobianco.service.PropagandaService;

@RestController
@RequestMapping("propaganda/")
@CrossOrigin(origins = "*")
public class PropagandaController {
    private PropagandaService propagandaService ;
    
        public PropagandaController(PropagandaService propagandaService) {
            this.propagandaService = propagandaService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Propaganda>> findAll() {
                List<Propaganda> propagandas = propagandaService.findAll();
                return new ResponseEntity<List<Propaganda>>(propagandas, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Propaganda> findById(@PathVariable("id") Long id) {
                Propaganda propaganda = propagandaService.findById(id);
                return new ResponseEntity<Propaganda>(propaganda, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Propaganda> create(@RequestBody Propaganda propaganda) {
                Propaganda propagandaSalvo = propagandaService.create(propaganda);
                return new ResponseEntity<Propaganda>(propagandaSalvo, HttpStatus.CREATED);
        }
    
        @PutMapping("update/{id}")
        public ResponseEntity<Propaganda> update(@PathVariable("id") Long id, @RequestBody Propaganda propaganda) {
                Propaganda propagandaEditado = propagandaService.update(id, propaganda);
                return new ResponseEntity<Propaganda>(propagandaEditado, HttpStatus.OK);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                propagandaService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
