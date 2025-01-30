package com.reyreey.filimo.Model.Content;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_seaeon")
public class Season extends Content {

    private TVSeries tvSeries;
    private List<MediaItem> episodes = new ArrayList<>();
    private ContentDetail detail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_detail",referencedColumnName = "id")
    public ContentDetail getDetail() {
        return detail;
    }

    public void setDetail(ContentDetail detail) {
        this.detail = detail;
    }

    @ManyToOne
    @JoinColumn(name = "c_tvSeries" , referencedColumnName = "id")
    public TVSeries getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(TVSeries tvSeries) {
        this.tvSeries = tvSeries;
    }

    @OneToMany(mappedBy = "season")
    @OrderColumn(name = "c_episodeNo" , columnDefinition = "integer default Null")
    public List<MediaItem> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<MediaItem> episodes) {
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

    @Override
    public String toString() {
        return tvSeries.toString() + " - " + detail.getTitle();
    }
}
