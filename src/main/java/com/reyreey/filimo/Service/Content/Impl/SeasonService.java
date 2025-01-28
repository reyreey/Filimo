package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.DTO.SeasonDTO;
import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Model.Content.PersonRole;
import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.Repository.Content.ISeasonRepository;
import com.reyreey.filimo.Service.Content.*;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.SeasonMapper;
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
public class SeasonService {

    @Autowired
    private ISeasonRepository seasonRepository;
    @Autowired
    private IContentDetailService contentDetailService;
    @Autowired
    private IMediaItemService mediaItemService;
//    @Autowired
//    private MediaItemService mediaItemService;
    @Autowired
    private IPersonRoleService personRoleService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private IVideoService videoService;

    @Transactional
    public SeasonDTO createSeason(SeasonDTO seasonDTO){
//        mediaItemService.createMediaItems(seasonDTO.getEpisodes());

        Season season = SeasonMapper.mapToEntity(seasonDTO);

        contentDetailService.insert(season.getDetail());

        //mige in 3taro hatman haminja save kon na too methode create
        for (MediaItem mediaItem : season.getEpisodes()) {
            mediaItem.setSeason(season);
            personRoleService.insertAll(mediaItem.getPersonRoles());
            personService.insertAll(mediaItem.getPersonRoles().stream().map(PersonRole::getPerson).toList());
            for (Video video : mediaItem.getVideos()) {
                video.setMediaItem(mediaItem);
            }
            videoService.insertAll(mediaItem.getVideos());
        }
        mediaItemService.insertAll(season.getEpisodes());

        return SeasonMapper.mapToDTO(seasonRepository.save(season));
    }

    @Transactional
    public List<SeasonDTO> createSeasons(List<SeasonDTO> seasonDTOs) {

//        for(SeasonDTO seasonDTO:seasonDTOs){
//
//            mediaItemService.createMediaItems(seasonDTO.getEpisodes());
//        }

        List<Season> seasons = seasonDTOs.stream().map(SeasonMapper::mapToEntity).toList();

        for(Season season:seasons){

            contentDetailService.insert(season.getDetail());

            for (MediaItem mediaItem : season.getEpisodes()){
                mediaItem.setSeason(season);
            }
            //mige in 3taro hatman haminja save kon na too methode create
            mediaItemService.insertAll(season.getEpisodes());
            for (MediaItem mediaItem : season.getEpisodes()) {
                personRoleService.insertAll(mediaItem.getPersonRoles());
                personService.insertAll(mediaItem.getPersonRoles().stream().map(PersonRole::getPerson).toList());
                for (Video video : mediaItem.getVideos()) {
                    video.setMediaItem(mediaItem);
                }
                videoService.insertAll(mediaItem.getVideos());
            }

        }
        List<SeasonDTO> createdSeasonDTOs=seasonRepository.saveAll(seasons).stream().map(SeasonMapper::mapToDTO).toList();

        return createdSeasonDTOs;
    }
}
