package com.reyreey.filimo.Controller.Content.api;

import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Service.Content.IMediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/10/2025, Friday
 **/

@RestController
@RequestMapping(path = "/api/media-item", produces = MediaType.APPLICATION_JSON_VALUE)
public class MediaItemController {

    @Autowired
    private IMediaItemService mediaItemService;

    @GetMapping(path = "/all")
    public List<MediaItem> getAllMediaItems(){
        return mediaItemService.findAll();
    }

    @GetMapping(path = "/{id}")
    public MediaItem getMediaItem(Long id){
        return mediaItemService.find(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addMediaItem(MediaItem mediaItem){
        //TODO: not worked because child objects(detail,personRoles,videos) is empty and not saved
        mediaItemService.insert(mediaItem);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMediaItem(MediaItem mediaItem){
        mediaItemService.change(mediaItem);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMediaItem(Long id){
        mediaItemService.remove(id);
    }

}
