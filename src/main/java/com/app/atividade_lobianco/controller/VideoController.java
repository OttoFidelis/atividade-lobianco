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

import com.app.atividade_lobianco.model.entity.Video;
import com.app.atividade_lobianco.service.VideoService;

@RestController
@RequestMapping("video/")
@CrossOrigin(origins = "*")
public class VideoController {
    private VideoService videoService ;
    
        public VideoController(VideoService videoService) {
            this.videoService = videoService;
        }

        @GetMapping("findAll")
        public ResponseEntity<List<Video>> findAll() {
                List<Video> videos = videoService.findAll();
                return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
        }
    
        @GetMapping("findById/{id}")
        public ResponseEntity<Video> findById(@PathVariable("id") Long id) {
                Video video = videoService.findById(id);
                return new ResponseEntity<Video>(video, HttpStatus.OK);
        }
    
        @PostMapping("create")
        public ResponseEntity<Video> create(@RequestBody Video video) {
                Video videoSalvo = videoService.create(video);
                return new ResponseEntity<Video>(videoSalvo, HttpStatus.CREATED);
        }
    
        @PutMapping("update/{id}")
        public ResponseEntity<Video> update(@PathVariable("id") Long id, @RequestBody Video video) {
                Video videoEditado = videoService.update(id, video);
                return new ResponseEntity<Video>(videoEditado, HttpStatus.OK);
        }
    
        @DeleteMapping("delete/{id}")
        public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
                videoService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
