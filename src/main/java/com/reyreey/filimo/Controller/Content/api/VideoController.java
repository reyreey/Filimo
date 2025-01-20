package com.reyreey.filimo.Controller.Content.api;

import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.Service.Content.IVideoService;
import com.reyreey.filimo.DTO.VideoDTO;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/10/2025, Friday
**/

@RestController
@RequestMapping(path = "/api/video")
public class VideoController {

    @Autowired
    private IVideoService videoService;

    @GetMapping(path = "/all")
    public List<VideoDTO> getAllVideos(){
        List<VideoDTO> videos = videoService.findAll().stream()
                .map(VideoMapper::mapToDTO)
                .toList();
        return videos;
    }

    @GetMapping(path = "/all2")
    public List<Video> getAllVideos2(){
        return videoService.findAll();
    }
}
