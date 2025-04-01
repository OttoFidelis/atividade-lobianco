package com.app.atividade_lobianco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.atividade_lobianco.model.entity.Cliente;
import com.app.atividade_lobianco.service.ClienteService;

@RestController
@RequestMapping("cliente/")
@CrossOrigin(origins = "*")
public class ClienteController {
    private ClienteService clienteService ;
    
        public ClienteController(ClienteService clienteService) {
            this.clienteService = clienteService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Cliente>> findAll() {
                List<Cliente> clientes = clienteService.findAll();
                return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Cliente> findById(@PathVariable("id") Long id) {
                Cliente cliente = clienteService.findById(id);
                return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
                Cliente clienteSalvo = clienteService.create(cliente);
                return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.CREATED);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                clienteService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
