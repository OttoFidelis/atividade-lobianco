package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.atividade_lobianco.model.entity.Usuario;
import com.app.atividade_lobianco.model.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Usuario _usuario = usuario.get();
            return _usuario;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar o usuario");
    }
    @Transactional
    public List<Usuario> findAll() {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return usuarios;
    }
    @Transactional
    public Usuario create(Usuario usuario) {
            Usuario usuarioSalvo = usuarioRepository.save(usuario);
            return usuarioSalvo;
    }

    @Transactional
    public void delete(long id) {
            usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario update(Long id, Usuario usuario) {
        Optional<Usuario> _usuario = usuarioRepository.findById(id);
        if (_usuario.isPresent()) {
            Usuario usuarioUpdate = _usuario.get();
            usuarioUpdate.setNome(usuario.getNome());
            return usuarioUpdate;
        } else
            throw new RuntimeException("Ocorreu um erro ao editar o usuario");
    }
}
