package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.*;
import com.reyreey.filimo.Repository.Content.*;
import jakarta.transaction.Transactional;
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

    private IMediaItemRepository mediaItemRepository;
    private IContentDetailRepository contentDetailRepository;
    private IPersonRepository personRepository;
    private IPersonRoleInMediaItemRepository personRoleInMediaItemRepository;
    private IVideoRepository  videoRepository;

    @Transactional
    public MediaItem createMediaItem(MediaItem mediaItem, ContentDetail contentDetail,
                                     List<Person> personList,List<Genre> genres,
                                     List<Video> videos, RoleType roleType){

        mediaItem.setGenres(genres);

        mediaItem.setDetail(contentDetail);
        contentDetailRepository.save(contentDetail);

        mediaItem.setVideos(videos);

        for(Video video : videos){
            video.setMediaItem(mediaItem);
            videoRepository.save(video);
        }

        List<PersonRoleInMediaItem> personRoleInMediaItemList = new ArrayList<>();
        for(Person person : personList){
            personRepository.save(person);
            PersonRoleInMediaItem personRoleInMediaItem = new PersonRoleInMediaItem();
            personRoleInMediaItem.setMediaItem(mediaItem);
            personRoleInMediaItem.setPerson(person);
            personRoleInMediaItem.setRoleType(roleType);

            personRoleInMediaItemRepository.save(personRoleInMediaItem);

            personRoleInMediaItemList.add(personRoleInMediaItem);
        }
        mediaItem.setPersonRoleInMediaItems(personRoleInMediaItemList);

       return mediaItemRepository.save(mediaItem);
    }
}
