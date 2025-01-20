package com.reyreey.filimo.Utill.CSVToDTO.Mapper;

import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.DTO.VideoDTO;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/

public class VideoMapper {
    public static Video mapToEntity(VideoDTO dto) {
        Video entity = new Video();

        entity.setUrl(dto.getUrl());
        entity.setQuality(dto.getQuality());

        return entity;
    }

    public static VideoDTO mapToDTO(Video entity) {
        VideoDTO dto = new VideoDTO();

        dto.setUrl(entity.getUrl());
        dto.setQuality(entity.getQuality());

        return dto;
    }
}
