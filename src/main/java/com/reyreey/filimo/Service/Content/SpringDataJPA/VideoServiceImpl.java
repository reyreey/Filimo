package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.Repository.Content.IVideoRepository;
import com.reyreey.filimo.Service.Content.Exceptions.DataNotFoundException;
import com.reyreey.filimo.Service.Content.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements IVideoService {

    @Autowired
    private IVideoRepository videoRepository;

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video find(Long id) {
        var video=videoRepository.findById(id);
        if(video.isEmpty()){
            throw new DataNotFoundException("Video not found");
        }
        return video.get();
    }

    @Override
    public Video insert(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void change(Video video) {
        if(videoRepository.existsById(video.getId())) {
            videoRepository.save(video);
        }
        else throw new DataNotFoundException("Video not found");
    }

    @Override
    public void remove(Long id) {
        if(videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
        }
        else throw new DataNotFoundException("Video not found");
    }

    @Override
    public List<Video> insertAll(List<Video> videoList) {
        return videoRepository.saveAll(videoList);
    }
}
