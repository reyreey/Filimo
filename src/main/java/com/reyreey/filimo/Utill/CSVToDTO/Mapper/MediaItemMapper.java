package com.reyreey.filimo.Utill.CSVToDTO.Mapper;

import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Model.Content.PersonRole;
import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.Utill.CSVToDTO.DTO.MediaItemDTO;

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
}
