package com.reyreey.filimo.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/20/2025, Monday
 **/

public class SeasonDTO {
    private List<MediaItemDTO> episodes = new ArrayList<>();
    private String code;
    private String title;
    private String summary;
    private LocalDate releaseDate;

    public List<MediaItemDTO> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<MediaItemDTO> episodes) {
        this.episodes = episodes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
