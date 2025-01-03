package com.reyreey.filimo.Model.Content;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "t_seaeon")
public class Season extends Content {

    private int seasonNo;
    private TVSeries tvSeries;
    private Set<MediaItem> episodes;

    @Column(name = "c_seasonNo")
    public int getSeasonNo() {
        return seasonNo;
    }

    public void setSeasonNo(int seasonNo) {
        this.seasonNo = seasonNo;
    }

    @ManyToOne
    @JoinColumn(name = "c_tvSeries" , referencedColumnName = "id")
    public TVSeries getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(TVSeries tvSeries) {
        this.tvSeries = tvSeries;
    }

    @OneToMany(mappedBy = "mediaItem")
    public Set<MediaItem> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<MediaItem> episodes) {
        this.episodes = episodes;
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
