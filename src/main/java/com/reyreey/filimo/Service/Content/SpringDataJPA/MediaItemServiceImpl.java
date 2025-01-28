package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Repository.Content.IMediaItemRepository;
import com.reyreey.filimo.Service.Content.Exceptions.DataNotFoundException;
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
            throw new DataNotFoundException("MediaItem not found");
        }
        return mediaItem.get();
    }

    @Override
    public MediaItem insert(MediaItem mediaItem) {
        return mediaItemRepository.save(mediaItem);
    }

    @Override
    public void change(MediaItem mediaItem) {
        if(!mediaItemRepository.existsById(mediaItem.getId())){
            throw new DataNotFoundException("MediaItem not found");
        }
        mediaItemRepository.save(mediaItem);
    }

    @Override
    public void remove(Long id) {
        if(!mediaItemRepository.existsById(id)){
            throw new DataNotFoundException("MediaItem not found");
        }
        mediaItemRepository.deleteById(id);
    }

    @Override
    public List<MediaItem> insertAll(List<MediaItem> mediaItems) {
        return mediaItemRepository.saveAll(mediaItems);
    }
}
