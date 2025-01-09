package com.reyreey.filimo.Model.Content;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "t_mediaItem")
public class MediaItem extends Content{

    private Season season;
    private Set<Video> videos;
    private ContentDetail detail;
    private int episodeNo;
    private Set<Genre> genres;
    private double rate;
    private Set<PersonRoleInMediaItem> personRoleInMediaItems;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_detail",referencedColumnName = "id")
    public ContentDetail getDetail() {
        return detail;
    }

    public void setDetail(ContentDetail detail) {
        this.detail = detail;
    }

    @ManyToOne
    @JoinColumn(name = "c_season", referencedColumnName = "id")
    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @OneToMany(mappedBy = "mediaItem")
    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    @Column(name = "c_episodeNo")
    public int getEpisodeNo() {
        return episodeNo;
    }

    public void setEpisodeNo(int episodeNo) {
        this.episodeNo = episodeNo;
    }

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "mm_mediaItem_genre",
            joinColumns = @JoinColumn(name = "mediaItem_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Column(name = "c_rate")
    public double getRate() {
        return rate;
    }

    public void setRate(double rating) {
        this.rate = rating;
    }

    @OneToMany(mappedBy = "mediaItem")
    public Set<PersonRoleInMediaItem> getPersonRoleInMediaItems() {
        return personRoleInMediaItems;
    }

    public void setPersonRoleInMediaItems(Set<PersonRoleInMediaItem> personRoleInMediaItems) {
        this.personRoleInMediaItems = personRoleInMediaItems;
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
