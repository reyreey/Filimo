package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.*;
import com.reyreey.filimo.Repository.Content.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

@Service
public class MediaItemService {

    @Autowired
    private IMediaItemRepository mediaItemRepository;
    @Autowired
    private IContentDetailRepository contentDetailRepository;
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IPersonRoleRepository personRoleRepository;
    @Autowired
    private IVideoRepository  videoRepository;

    @Transactional
    public MediaItem createMediaItem(MediaItem mediaItem, ContentDetail contentDetail,
                                     List<PersonRole> personRoleList,List<Genre> genres,
                                     List<Video> videos,double rate,Integer episodeNo){

        mediaItem.setEpisodeNo(episodeNo);
        mediaItem.setRate(rate);

        mediaItem.setGenres(genres);

        mediaItem.setDetail(contentDetail);
        contentDetailRepository.save(contentDetail);

        mediaItem.setVideos(videos);

        for(Video video : videos){
            video.setMediaItem(mediaItem);
            videoRepository.save(video);
        }

        mediaItem.setPersonRoles(personRoleList);
        for(PersonRole personRole : personRoleList){
            personRepository.save(personRole.getPerson());

            personRole.getMediaItemList().add(mediaItem);
            personRoleRepository.save(personRole);
        }

       return mediaItemRepository.save(mediaItem);
    }
}
