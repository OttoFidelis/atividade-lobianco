package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.app.atividade_lobianco.model.entity.Empresa;
import com.app.atividade_lobianco.model.entity.Usuario;
import com.app.atividade_lobianco.model.repository.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {
 private EmpresaRepository empresaRepository;
    private UsuarioService usuarioService;

    public EmpresaService(EmpresaRepository empresaRepository, UsuarioService usuarioService) {
        this.empresaRepository = empresaRepository;
        this.usuarioService = usuarioService;
    }

    @Transactional
    public Empresa findById(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            Empresa _empresa = empresa.get();
            return _empresa;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar a empresa");
    }
    @Transactional
    public List<Empresa> findAll() {
            List<Empresa> empresas = empresaRepository.findAll();
            return empresas;
    }
    @Transactional
    public Empresa create(Empresa empresa) {
            Usuario usuario = empresa.getUsuario();
            usuario.setTipoUsuario("CLIENTE");
            usuarioService.create(usuario);
            return empresaRepository.save(empresa);
    }

    @Transactional
    public void delete(long id) {
            Empresa empresa = findById(id);
            usuarioService.delete(empresa.getUsuario().getId());
            empresaRepository.deleteById(id);
    }

    @Transactional
    public Empresa update(Long id, Empresa empresa) {
        Optional<Empresa> _empresa = empresaRepository.findById(id);
        if (_empresa.isPresent()) {
            Empresa empresaUpdate = _empresa.get();
            empresaUpdate.setEndereço(empresa.getEndereço());
            empresaUpdate.setEmail(empresa.getEmail());
            empresaUpdate.setTelefone(empresa.getTelefone());
            return empresaUpdate;
        } else
            throw new RuntimeException("Ocorreu um erro ao editar a empresa");
    }
}
