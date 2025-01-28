package com.reyreey.filimo.Utill.CSVToDTO.Mapper;

import com.reyreey.filimo.DTO.Factory.TVSeriesDTOFactory;
import com.reyreey.filimo.DTO.SeasonDTO;
import com.reyreey.filimo.DTO.TVSeriesDTO;
import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Model.Content.Factory.ContentDetailFactory;
import com.reyreey.filimo.Model.Content.Factory.TVSeriesFactory;
import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Model.Content.TVSeries;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/28/2025, Tuesday
 **/

public class TVSeriesMapper {
    public static TVSeries mapToEntity(TVSeriesDTO dto) {

        ContentDetail contentDetail = ContentDetailFactory.createContentDetail(dto.getCode(), dto.getTitle(),
                dto.getSummary(),dto.getReleaseDate());

        List<Season> seasons = dto.getSeasons().stream().map(SeasonMapper::mapToEntity).toList();

        return TVSeriesFactory.createTVSeries(seasons,dto.isFinished(),contentDetail);
    }

    public static TVSeriesDTO mapToDTO(TVSeries entity) {

        List<SeasonDTO> seasons = entity.getSeasons().stream().map(SeasonMapper::mapToDTO).toList();

        ContentDetail contentDetail = entity.getDetail();

        return TVSeriesDTOFactory.createTVSeriesDTO(seasons,entity.isFinished(),contentDetail.getCode(),
                contentDetail.getTitle(),contentDetail.getSummary(),contentDetail.getReleaseDate());
    }
}


