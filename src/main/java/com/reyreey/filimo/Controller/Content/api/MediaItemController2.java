package com.reyreey.filimo.Controller.Content.api;

import com.reyreey.filimo.DTO.MediaItemDTO;
import com.reyreey.filimo.Service.Content.Impl.MediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

@RestController
@RequestMapping(path = "/api")
public class MediaItemController2 {

    @Autowired
    private MediaItemService mediaItemService;


    @PostMapping(path = "/add-media-item")
    public ResponseEntity<MediaItemDTO> createMediaItem(@RequestBody MediaItemDTO mediaItemDTO){


        MediaItemDTO createdMediaItem = mediaItemService.createMediaItem(mediaItemDTO);

        return ResponseEntity.ok(createdMediaItem);
    }

    @PostMapping(path = "/add-media-items")
    public ResponseEntity<List<MediaItemDTO>> createMediaItems(@RequestBody List<MediaItemDTO> mediaItemDTOs){


        List<MediaItemDTO> createdMediaItems = mediaItemService.createMediaItems(mediaItemDTOs);

        return ResponseEntity.ok(createdMediaItems);
    }
}
