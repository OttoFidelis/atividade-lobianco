package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.atividade_lobianco.model.entity.Cliente;
import com.app.atividade_lobianco.model.entity.Usuario;
import com.app.atividade_lobianco.model.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private UsuarioService usuarioService;

    public ClienteService(ClienteRepository clienteRepository, UsuarioService usuarioService) {
        this.clienteRepository = clienteRepository;
        this.usuarioService = usuarioService;
    }

    @Transactional
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            Cliente _cliente = cliente.get();
            return _cliente;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar o cliente");
    }
    @Transactional
    public List<Cliente> findAll() {
            List<Cliente> clientes = clienteRepository.findAll();
            return clientes;
    }
    @Transactional
    public Cliente create(Cliente cliente) {
            Usuario usuario = cliente.getUsuario();
            usuario.setTipoUsuario("CLIENTE");
            usuarioService.create(usuario);
            return clienteRepository.save(cliente);
    }

    @Transactional
    public void delete(long id) {
            Cliente cliente = findById(id);
            usuarioService.delete(cliente.getUsuario().getId());
            clienteRepository.deleteById(id);
    }
}
