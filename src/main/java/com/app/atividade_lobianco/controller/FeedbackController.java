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

import com.app.atividade_lobianco.model.entity.Feedback;
import com.app.atividade_lobianco.service.FeedbackService;

@RestController
@RequestMapping("feedback/")
@CrossOrigin(origins = "*")
public class FeedbackController {
    private FeedbackService feedbackService ;
    
        public FeedbackController(FeedbackService feedbackService) {
            this.feedbackService = feedbackService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Feedback>> findAll() {
                List<Feedback> feedbacks = feedbackService.findAll();
                return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Feedback> findById(@PathVariable("id") Long id) {
                Feedback feedback = feedbackService.findById(id);
                return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Feedback> create(@RequestBody Feedback feedback) {
                Feedback feedbackSalvo = feedbackService.create(feedback);
                return new ResponseEntity<Feedback>(feedbackSalvo, HttpStatus.CREATED);
        }
    
        @PutMapping("update/{id}")
        public ResponseEntity<Feedback> update(@PathVariable("id") Long id, @RequestBody Feedback feedback) {
                Feedback feedbackEditado = feedbackService.update(id, feedback);
                return new ResponseEntity<Feedback>(feedbackEditado, HttpStatus.OK);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                feedbackService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
