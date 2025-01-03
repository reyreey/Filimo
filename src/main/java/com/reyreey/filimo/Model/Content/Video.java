package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "t_video")
public class Video extends BaseEntity {
    private String url;
    private Quality quality;

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
}
