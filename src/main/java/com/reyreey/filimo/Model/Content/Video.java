package com.reyreey.filimo.Model.Content;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "t_video")
public class Video extends BaseEntity {
    private String url;
    private Quality quality;
    @JsonIgnore
    private MediaItem mediaItem;

    @Column(name = "c_url" , nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "c_quality")
    @Enumerated(EnumType.STRING)
    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @ManyToOne
    @JoinColumn(name = "c_mediaItem",referencedColumnName = "id")
    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    @Override
    public String toString() {
        return "Video{" +
                "url='" + url + '\'' +
                ", quality=" + quality +
                '}';
    }
}
