package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.Repository.Content.VideoRepository;
import com.reyreey.filimo.Service.Content.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video find(Long id) {
        var video=videoRepository.findById(id);
        if(video.isEmpty()){
            //TODO data not found exception
            throw new RuntimeException("Video not found");
        }
        return video.get();
    }

    @Override
    public Boolean isExists(String title) {
        return videoRepository.existsByTitle(title);
    }

    @Override
    public void insert(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void change(Video video) {
        if(videoRepository.existsById(video.getId())) {
            videoRepository.save(video);
        }
        //TODO data not found exception
        else throw new RuntimeException("Video not found");
    }

    @Override
    public void remove(Long id) {
        if(videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
        }
        //TODO data not found exception
        else throw new RuntimeException("Video not found");
    }
}
