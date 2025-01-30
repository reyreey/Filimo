package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.DTO.MediaItemDTO;
import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Model.Content.PersonRole;
import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Model.Content.Video;
import com.reyreey.filimo.Repository.Content.IMediaItemRepository;
import com.reyreey.filimo.Service.Content.*;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.MediaItemMapper;
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
public class MediaItemService  {

    @Autowired
    private IMediaItemRepository mediaItemRepository;
    @Autowired
    private IContentDetailService contentDetailService;
    @Autowired
    private IPersonRoleService personRoleService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IVideoService videoService;

    @Autowired
    private ISeasonService seasonService;

    @Transactional
    public MediaItemDTO createMediaItem(MediaItemDTO mediaItemDTO,Long seasonId){

        MediaItem mediaItem = MediaItemMapper.mapToEntity(mediaItemDTO);

        contentDetailService.insert(mediaItem.getDetail());

        //mige in 2taro hatman haminja save kon na too methode create
        personRoleService.insertAll(mediaItem.getPersonRoles());
        personService.insertAll(mediaItem.getPersonRoles().stream().map(PersonRole::getPerson).toList());

        for(Video video : mediaItem.getVideos()){
            video.setMediaItem(mediaItem);
        }
        videoService.insertAll(mediaItem.getVideos());

        if (seasonId != null) {
            Season season = seasonService.find(seasonId);
            mediaItem.setSeason(season);
        }

       return MediaItemMapper.mapToDTO(mediaItemRepository.save(mediaItem));
    }

    @Transactional
    public List<MediaItemDTO> createMediaItems(List<MediaItemDTO> mediaItemDTOs, Long seasonId) {

        Season season = null;
        if (seasonId != null) {
            season = seasonService.find(seasonId);
        }

        List<MediaItem> mediaItems=mediaItemDTOs.stream().map(MediaItemMapper::mapToEntity).toList();

        for (MediaItem mediaItem : mediaItems) {
            //mige in 2taro hatman haminja save kon na too methode create
            personRoleService.insertAll(mediaItem.getPersonRoles());
            personService.insertAll(mediaItem.getPersonRoles().stream().map(PersonRole::getPerson).toList());

            contentDetailService.insert(mediaItem.getDetail());

            for(Video video : mediaItem.getVideos()){
                video.setMediaItem(mediaItem);
            }
            videoService.insertAll(mediaItem.getVideos());

            mediaItem.setSeason(season);
        }

        List<MediaItemDTO> createdMediaItems=mediaItemRepository.saveAll(mediaItems).stream().map(MediaItemMapper::mapToDTO).toList();

        return createdMediaItems;
    }
}
