package com.reyreey.filimo.DTO.Factory;

import com.reyreey.filimo.DTO.SeasonDTO;
import com.reyreey.filimo.DTO.TVSeriesDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/28/2025, Tuesday
 **/

public class TVSeriesDTOFactory {
    public static TVSeriesDTO createTVSeriesDTO(List<SeasonDTO> seasons, boolean isFinished, String code,String title,
                                             String summary, LocalDate releaseDate) {
        TVSeriesDTO tvSeriesDTO = new TVSeriesDTO();

        tvSeriesDTO.setSeasons(seasons);
        tvSeriesDTO.setFinished(isFinished);
        tvSeriesDTO.setCode(code);
        tvSeriesDTO.setTitle(title);
        tvSeriesDTO.setSummary(summary);
        tvSeriesDTO.setReleaseDate(releaseDate);


        return tvSeriesDTO;
    }
}
