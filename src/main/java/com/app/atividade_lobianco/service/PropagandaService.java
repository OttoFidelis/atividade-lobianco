package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.atividade_lobianco.model.entity.Propaganda;
import com.app.atividade_lobianco.model.repository.PropagandaRepository;

import jakarta.transaction.Transactional;

@Service
public class PropagandaService {
    private PropagandaRepository propagandaRepository;

    public PropagandaService(PropagandaRepository propagandaRepository) {
        this.propagandaRepository = propagandaRepository;
    }

    @Transactional
    public Propaganda findById(Long id) {
        Optional<Propaganda> propaganda = propagandaRepository.findById(id);
        if (propaganda.isPresent()) {
            Propaganda _propaganda = propaganda.get();
            return _propaganda;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar o propaganda");
    }
    @Transactional
    public List<Propaganda> findAll() {
            List<Propaganda> propagandas = propagandaRepository.findAll();
            return propagandas;
    }
    @Transactional
    public Propaganda create(Propaganda propaganda) {
            Propaganda propagandaSalvo = propagandaRepository.save(propaganda);
            return propagandaSalvo;
    }

    @Transactional
    public void delete(long id) {
            propagandaRepository.deleteById(id);
    }

    @Transactional
    public Propaganda update(Long id, Propaganda propaganda) {
        Optional<Propaganda> _propaganda = propagandaRepository.findById(id);
        if (_propaganda.isPresent()) {
            Propaganda propagandaUpdate = _propaganda.get();
            propagandaUpdate.setVideo(propaganda.getVideo());
            return propagandaUpdate;
        } else
            throw new RuntimeException("Ocorreu um erro ao editar o propaganda");
    }
}
