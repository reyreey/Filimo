package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.DTO.TVSeriesDTO;
import com.reyreey.filimo.Model.Content.*;
import com.reyreey.filimo.Repository.Content.ITVSeriesRepository;
import com.reyreey.filimo.Service.Content.*;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.TVSeriesMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

@Service
public class TVSeriesService {

    @Autowired
    private ITVSeriesRepository tvSeriesRepository;

    @Autowired
    private IContentDetailService contentDetailService;

    @Autowired
    private ISeasonService seasonService;

    @Autowired
    private IMediaItemService mediaItemService;

    @Autowired
    private IPersonRoleService PersonRoleService;
    @Autowired
    private IPersonService personService;

    @Autowired
    private IVideoService videoService;

    @Transactional
    public TVSeriesDTO createTVSeries(TVSeriesDTO tvSeriesDTO) {
        TVSeries tvSeries = TVSeriesMapper.mapToEntity(tvSeriesDTO);

        contentDetailService.insert(tvSeries.getDetail());

        for (Season season : tvSeries.getSeasons()) {
            season.setTvSeries(tvSeries);
            for (MediaItem mediaItem : season.getEpisodes()) {
                mediaItem.setSeason(season);
                PersonRoleService.insertAll(mediaItem.getPersonRoles());
                personService.insertAll(mediaItem.getPersonRoles().stream().map(PersonRole::getPerson).toList());
                for (Video video : mediaItem.getVideos()) {
                    video.setMediaItem(mediaItem);
                }
                videoService.insertAll(mediaItem.getVideos());
            }
            mediaItemService.insertAll(season.getEpisodes());
        }
        seasonService.insertAll(tvSeries.getSeasons());

        return TVSeriesMapper.mapToDTO(tvSeriesRepository.save(tvSeries));
    }

    @Transactional
    public List<TVSeriesDTO> createTVSeriesList(List<TVSeriesDTO> tvSeriesDTOList) {
        List<TVSeries> tvSeriesList = tvSeriesDTOList.stream().map(TVSeriesMapper::mapToEntity).toList();

        for (TVSeries tvSeries : tvSeriesList) {
            contentDetailService.insert(tvSeries.getDetail());

            for (Season season : tvSeries.getSeasons()) {
                season.setTvSeries(tvSeries);
                for (MediaItem mediaItem : season.getEpisodes()) {
                    mediaItem.setSeason(season);
                    PersonRoleService.insertAll(mediaItem.getPersonRoles());
                    personService.insertAll(mediaItem.getPersonRoles().stream().map(PersonRole::getPerson).toList());
                    for (Video video : mediaItem.getVideos()) {
                        video.setMediaItem(mediaItem);
                    }
                    videoService.insertAll(mediaItem.getVideos());
                }
                mediaItemService.insertAll(season.getEpisodes());
            }
            seasonService.insertAll(tvSeries.getSeasons());
        }
        return tvSeriesRepository.saveAll(tvSeriesList).stream().map(TVSeriesMapper::mapToDTO).toList();
    }

}
