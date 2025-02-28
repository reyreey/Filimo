package com.reyreey.filimo.Model.Content.Factory;

import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Model.Content.TVSeries;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 2/14/2025, Friday
 **/

public class SeasonFactory {
    public static Season createSeason(List<MediaItem> mediaItems, TVSeries tvSeries, ContentDetail contentDetail) {
        Season season = new Season();

        season.setEpisodes(mediaItems);
        season.setTvSeries(tvSeries);
        season.setDetail(contentDetail);


        return season;
    }
}
