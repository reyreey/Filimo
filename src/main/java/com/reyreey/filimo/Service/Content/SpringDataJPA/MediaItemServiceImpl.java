package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Repository.Content.IMediaItemRepository;
import com.reyreey.filimo.Service.Content.IMediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaItemServiceImpl implements IMediaItemService {

    @Autowired
    private IMediaItemRepository mediaItemRepository;

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
