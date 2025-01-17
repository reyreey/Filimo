package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Repository.Content.IContentDetailRepository;
import com.reyreey.filimo.Repository.Content.IMediaItemRepository;
import com.reyreey.filimo.Repository.Content.ISeasonRepository;
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
    private IContentDetailRepository contentDetailRepository;

    @Transactional
    public Season createSeason(Season season, ContentDetail contentDetail, List<MediaItem> mediaItems){

        season.setDetail(contentDetail);

        contentDetailRepository.save(contentDetail);

        season.setEpisodes(mediaItems);

        for (MediaItem mediaItem : mediaItems){
            mediaItem.setSeason(season);
        }

        return seasonRepository.save(season);
    }
}
