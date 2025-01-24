package com.reyreey.filimo.Utill.CSVToDTO.Mapper;

import com.reyreey.filimo.DTO.SeasonDTO;
import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Model.Content.Season;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/20/2025, Monday
 **/

public class SeasonMapper {

    public static Season mapToEntity(SeasonDTO dto) {
        Season entity = new Season();

        entity.setEpisodes(dto.getEpisodes().stream()
                .map(MediaItemMapper::mapToEntity)
                .toList());

        entity.setSeasonNo(dto.getSeasonNo());

        ContentDetail  contentDetail = new ContentDetail();
        contentDetail.setCode(dto.getCode());
        contentDetail.setTitle(dto.getTitle());
        contentDetail.setSummary(dto.getSummary());
        contentDetail.setReleaseDate(dto.getReleaseDate());

        entity.setDetail(contentDetail);

        return entity;
    }

    public static SeasonDTO mapToDTO(Season entity) {
        SeasonDTO dto = new SeasonDTO();

        dto.setEpisodes(entity.getEpisodes().stream()
                .map(MediaItemMapper::mapToDTO)
                .toList());

        dto.setCode(entity.getDetail().getCode());
        dto.setTitle(entity.getDetail().getTitle());
        dto.setSummary(entity.getDetail().getSummary());
        dto.setReleaseDate(entity.getDetail().getReleaseDate());

        dto.setSeasonNo(entity.getSeasonNo());

        return dto;
    }


}
