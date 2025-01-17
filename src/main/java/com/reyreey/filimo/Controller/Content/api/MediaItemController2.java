package com.reyreey.filimo.Controller.Content.api;

import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Service.Content.Impl.MediaItemService;
import com.reyreey.filimo.Utill.CSVToDTO.DTO.MediaItemDTO;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.MediaItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

@RestController
@RequestMapping(path = "/api/media-items")
public class MediaItemController2 {

    @Autowired
    private MediaItemService mediaItemService;


    @PostMapping
    public ResponseEntity<MediaItem> createMediaItem(@RequestBody MediaItemDTO mediaItemDTO){
        MediaItem mediaItem = MediaItemMapper.mapToEntity(mediaItemDTO);


        MediaItem createdMediaItem = mediaItemService.createMediaItem(mediaItem,mediaItem.getDetail(),
                mediaItem.getPersonRoles(), mediaItem.getGenres(),mediaItem.getVideos(),mediaItem.getRate(),mediaItem.getEpisodeNo());

        return ResponseEntity.ok(createdMediaItem);
    }
}
