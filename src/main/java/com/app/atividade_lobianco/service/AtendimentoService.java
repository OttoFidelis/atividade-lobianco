package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.atividade_lobianco.model.entity.Atendimento;
import com.app.atividade_lobianco.model.repository.AtendimentoRepository;

import jakarta.transaction.Transactional;

@Service
public class AtendimentoService {
    private AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    @Transactional
    public Atendimento findById(Long id) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if (atendimento.isPresent()) {
            Atendimento _atendimento = atendimento.get();
            return _atendimento;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar o atendimento");
    }
    @Transactional
    public List<Atendimento> findAll() {
            List<Atendimento> atendimentos = atendimentoRepository.findAll();
            return atendimentos;
    }
    @Transactional
    public Atendimento create(Atendimento atendimento) {
            Atendimento atendimentoSalvo = atendimentoRepository.save(atendimento);
            return atendimentoSalvo;
    }

    @Transactional
    public void delete(long id) {
            atendimentoRepository.deleteById(id);
    }

    @Transactional
    public Atendimento update(Long id, Atendimento atendimento) {
        Optional<Atendimento> _atendimento = atendimentoRepository.findById(id);
        if (_atendimento.isPresent()) {
            Atendimento atendimentoUpdate = _atendimento.get();
            atendimentoUpdate.setCategoria(atendimento.getCategoria());
            atendimentoUpdate.setData(atendimento.getData());
            atendimentoUpdate.setPrioridade(atendimento.getPrioridade());
            return atendimentoUpdate;
        } else
            throw new RuntimeException("Ocorreu um erro ao editar o atendimento");
    }
}
