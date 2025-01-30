package com.reyreey.filimo.Controller.Content.api;

import com.reyreey.filimo.DTO.MediaItemDTO;
import com.reyreey.filimo.Service.Content.Impl.MediaItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MediaItemDTO> createMediaItem(@Valid@RequestBody MediaItemDTO mediaItemDTO,
                                                        @RequestParam(required = false) Long seasonId){


        MediaItemDTO createdMediaItem = mediaItemService.createMediaItem(mediaItemDTO,seasonId);

        return ResponseEntity.ok(createdMediaItem);
    }

    @PostMapping(path = "/add-media-items")
    public ResponseEntity<List<MediaItemDTO>> createMediaItems(@Valid@RequestBody List<MediaItemDTO> mediaItemDTOs,@RequestParam(required = false) Long seasonId){


        List<MediaItemDTO> createdMediaItems = mediaItemService.createMediaItems(mediaItemDTOs,seasonId);

        return ResponseEntity.ok(createdMediaItems);
    }
}
