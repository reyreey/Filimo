package com.reyreey.filimo.Model.Content;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "t_mediaItem")
public class MediaItem extends Content{

    private Season season;
    private Set<Video> videos;

    @ManyToOne
    @JoinColumn(name = "c_season", referencedColumnName = "id")
    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @OneToMany(mappedBy = "video")
    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    @Override
    public void play() {

    }

    @Override
    public void setEnable() {

    }

    @Override
    public void setDisable() {

    }

    @Override
    public void confirm() {

    }
}
