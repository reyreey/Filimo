package com.reyreey.filimo.Model.Content;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_tvSeries")
public class TVSeries extends Content{

    private List<Season> seasons = new ArrayList<>();
    private boolean isFinished;
    private ContentDetail detail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_detail",referencedColumnName = "id")
    public ContentDetail getDetail() {
        return detail;
    }

    public void setDetail(ContentDetail detail) {
        this.detail = detail;
    }

    @OneToMany(mappedBy = "tvSeries")
    @OrderColumn(name = "c_seasonNo", columnDefinition = "integer default Null")
    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    @Column(name = "c_isFinished")
    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
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
        return "TVSeries{" +
                "seasons=" + seasons +
                ", isFinished=" + isFinished +
                ", detail=" + detail +
                '}';
    }
}
