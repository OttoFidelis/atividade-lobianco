package com.app.atividade_lobianco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.atividade_lobianco.model.entity.Video;
import com.app.atividade_lobianco.model.repository.VideoRepository;

import jakarta.transaction.Transactional;

@Service
public class VideoService {
    private VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Transactional
    public Video findById(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent()) {
            Video _video = video.get();
            return _video;
        } else
            throw new RuntimeException("Ocorreu um erro ao buscar o video");
    }
    @Transactional
    public List<Video> findAll() {
            List<Video> videos = videoRepository.findAll();
            return videos;
    }
    @Transactional
    public Video create(Video video) {
            Video videoSalvo = videoRepository.save(video);
            return videoSalvo;
    }

    @Transactional
    public void delete(long id) {
            videoRepository.deleteById(id);
    }

    @Transactional
    public Video update(Long id, Video video) {
        Optional<Video> _video = videoRepository.findById(id);
        if (_video.isPresent()) {
            Video videoUpdate = _video.get();
            videoUpdate.setArquivo(video.getArquivo());
            return videoUpdate;
        } else
            throw new RuntimeException("Ocorreu um erro ao editar o video");
    }
}
