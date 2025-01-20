package com.reyreey.filimo.Utill.CSVToDTO.Mapper;

import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Model.Content.PersonRole;
import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.DTO.MediaItemDTO;
import com.reyreey.filimo.DTO.PersonRoleDTO;
import com.reyreey.filimo.DTO.VideoDTO;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

public class MediaItemMapper {
    public static MediaItem mapToEntity(MediaItemDTO dto) {
        MediaItem entity = new MediaItem();

        List<Video> videos = dto.getVideos().stream()
                .map(VideoMapper::mapToEntity)
                .toList();

        entity.setVideos(videos);
        entity.setGenres(dto.getGenres());

        ContentDetail contentDetail = new ContentDetail();
        contentDetail.setCode(dto.getCode());
        contentDetail.setSummary(dto.getSummary());
        contentDetail.setTitle(dto.getTitle());
        contentDetail.setReleaseDate(dto.getReleaseDate());
        entity.setDetail(contentDetail);

        entity.setRate(dto.getRate());

        List<PersonRole> personRoles = dto.getPersonRoles().stream()
                .map(PersonRoleMapper::mapToEntity)
                .toList();

        entity.setPersonRoles(personRoles);

        entity.setRate(dto.getRate());
        entity.setEpisodeNo(dto.getEpisodeNo());

        return entity;
    }

    public static MediaItemDTO mapToDTO(MediaItem entity) {
        MediaItemDTO dto = new MediaItemDTO();

        List<VideoDTO> videos = entity.getVideos().stream()
                .map(VideoMapper::mapToDTO)
                .toList();

        dto.setVideos(videos);
        dto.setGenres(entity.getGenres());

        dto.setCode(entity.getDetail().getCode());
        dto.setSummary(entity.getDetail().getSummary());
        dto.setTitle(entity.getDetail().getTitle());
        dto.setReleaseDate(entity.getDetail().getReleaseDate());

        dto.setRate(entity.getRate());

        List<PersonRoleDTO> personRoles = entity.getPersonRoles().stream()
                .map(PersonRoleMapper::mapToDTO)
                .toList();

        dto.setPersonRoles(personRoles);

        dto.setRate(entity.getRate());
        dto.setEpisodeNo(entity.getEpisodeNo());

        return dto;
    }
}
