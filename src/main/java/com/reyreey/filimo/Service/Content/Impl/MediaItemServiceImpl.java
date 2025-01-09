package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Repository.Content.MediaItemRepository;
import com.reyreey.filimo.Service.Content.MediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaItemServiceImpl implements MediaItemService {

    @Autowired
    private MediaItemRepository mediaItemRepository;

    @Override
    public List<MediaItem> findAll() {
        return mediaItemRepository.findAll();
    }

    @Override
    public MediaItem find(Long id) {
        var mediaItem = mediaItemRepository.findById(id);
        if(mediaItem.isEmpty()){
            //TODO data not found exception
            throw new RuntimeException("MediaItem not found");
        }
        return mediaItem.get();
    }

    @Override
    public Boolean isExists(String title) {
        return mediaItemRepository.existsByTitle(title);
    }

    @Override
    public void insert(MediaItem mediaItem) {
        mediaItemRepository.save(mediaItem);
    }

    @Override
    public void change(MediaItem mediaItem) {
        if(!mediaItemRepository.existsById(mediaItem.getId())){
            //TODO data not found exception
            throw new RuntimeException("MediaItem not found");
        }
        mediaItemRepository.save(mediaItem);
    }

    @Override
    public void remove(Long id) {
        if(!mediaItemRepository.existsById(id)){
            //TODO data not found exception
            throw new RuntimeException("MediaItem not found");
        }
        mediaItemRepository.deleteById(id);
    }
}
