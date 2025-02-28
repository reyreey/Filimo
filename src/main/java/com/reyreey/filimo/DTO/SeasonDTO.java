package com.reyreey.filimo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/20/2025, Monday
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonDTO {
    private List<MediaItemDTO> episodes = new ArrayList<>();
    @NotNull(message = "{notnull}")
    private String code;
    private String title;
    private String summary;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @NotNull(message = "{notnull}")
    private String tvSeries;

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

    public String getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(String tvSeries) {
        this.tvSeries = tvSeries;
    }
}
