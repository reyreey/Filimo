package com.reyreey.filimo.Model.Content.Builder;

import com.reyreey.filimo.Model.Content.*;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 4/28/2025, Monday
 **/

public final class MediaItemBuilder {
    private Season season;
    private List<Video> videos;
    private ContentDetail detail;
    private List<Genre> genres;
    private double rate;
    private List<PersonRole> personRoles;

    private MediaItemBuilder() {
    }

    public static MediaItemBuilder aMediaItem() {
        return new MediaItemBuilder();
    }

    public MediaItemBuilder withSeason(Season season) {
        this.season = season;
        return this;
    }

    public MediaItemBuilder withVideos(List<Video> videos) {
        this.videos = videos;
        return this;
    }

    public MediaItemBuilder withDetail(ContentDetail detail) {
        this.detail = detail;
        return this;
    }

    public MediaItemBuilder withGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public MediaItemBuilder withRate(double rate) {
        this.rate = rate;
        return this;
    }

    public MediaItemBuilder withPersonRoles(List<PersonRole> personRoles) {
        this.personRoles = personRoles;
        return this;
    }

    public MediaItem build() {
        MediaItem mediaItem = new MediaItem();
        mediaItem.setSeason(season);
        mediaItem.setVideos(videos);
        mediaItem.setDetail(detail);
        mediaItem.setGenres(genres);
        mediaItem.setRate(rate);
        mediaItem.setPersonRoles(personRoles);
        return mediaItem;
    }
}
