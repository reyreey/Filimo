package com.reyreey.filimo.Controller.Content.view;

import com.reyreey.filimo.Service.Content.IMediaItemService;
import com.reyreey.filimo.DTO.MediaItemDTO;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.MediaItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/

@Controller
public class MediaItemViewController {

    @Autowired
    private IMediaItemService mediaItemService;

    @GetMapping("/mediaItems")
    public String getAllMediaItems(Model model) {
        List<MediaItemDTO> mediaItems = mediaItemService.findAll()
                .stream()
                .map(MediaItemMapper::mapToDTO)
                .toList();
        // ارسال لیست به View
        model.addAttribute("mediaItems", mediaItems);

        return "mediaItems/mediaItems"; // نام View
    }

    @GetMapping("/mediaItemsGrid")
    public String getAllMediaItemsGrid(Model model) {
        List<MediaItemDTO> mediaItems = mediaItemService.findAll()
                .stream()
                .map(MediaItemMapper::mapToDTO)
                .toList();
        // ارسال لیست به View
        model.addAttribute("mediaItems", mediaItems);

        return "mediaItems/mediaItemsGrid"; // نام View
    }
}
