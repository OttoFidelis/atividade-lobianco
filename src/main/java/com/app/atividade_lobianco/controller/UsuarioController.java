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

import com.app.atividade_lobianco.model.entity.Usuario;
import com.app.atividade_lobianco.service.UsuarioService;

@RestController
@RequestMapping("usuario/")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private UsuarioService usuarioService ;
    
        public UsuarioController(UsuarioService usuarioService) {
            this.usuarioService = usuarioService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Usuario>> findAll() {
                List<Usuario> usuarios = usuarioService.findAll();
                return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) {
                Usuario usuario = usuarioService.findById(id);
                return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
                Usuario usuarioSalvo = usuarioService.create(usuario);
                return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.CREATED);
        }
    
        @PutMapping("update/{id}")
        public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
                Usuario usuarioEditado = usuarioService.update(id, usuario);
                return new ResponseEntity<Usuario>(usuarioEditado, HttpStatus.OK);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                usuarioService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
