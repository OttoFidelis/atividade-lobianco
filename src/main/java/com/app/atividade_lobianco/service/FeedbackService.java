package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.atividade_lobianco.model.entity.Feedback;
import com.app.atividade_lobianco.model.repository.FeedbackRepository;

import jakarta.transaction.Transactional;

@Service
public class FeedbackService {
    private FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Transactional
    public Feedback findById(Long id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);
        if (feedback.isPresent()) {
            Feedback _feedback = feedback.get();
            return _feedback;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar o feedback");
    }
    @Transactional
    public List<Feedback> findAll() {
            List<Feedback> feedbacks = feedbackRepository.findAll();
            return feedbacks;
    }
    @Transactional
    public Feedback create(Feedback feedback) {
            Feedback feedbackSalvo = feedbackRepository.save(feedback);
            return feedbackSalvo;
    }

    @Transactional
    public void delete(long id) {
            feedbackRepository.deleteById(id);
    }

    @Transactional
    public Feedback update(Long id, Feedback feedback) {
        Optional<Feedback> _feedback = feedbackRepository.findById(id);
        if (_feedback.isPresent()) {
            Feedback feedbackUpdate = _feedback.get();
            feedbackUpdate.setTexto(feedback.getTexto());
            return feedbackUpdate;
        } else
            throw new RuntimeException("Ocorreu um erro ao editar o feedback");
    }
}
