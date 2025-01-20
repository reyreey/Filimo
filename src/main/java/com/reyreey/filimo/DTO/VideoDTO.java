package com.reyreey.filimo.DTO;

import com.reyreey.filimo.Model.Content.Quality;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/

public class VideoDTO {
    private String url;
    private Quality quality;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }
}
