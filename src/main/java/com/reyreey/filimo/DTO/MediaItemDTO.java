package com.reyreey.filimo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reyreey.filimo.Model.Content.Genre;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaItemDTO {
    private List<VideoDTO> videos = new ArrayList<>();
    private String code;
    @NotNull(message = "{notnull}")
    private String title;
    private String summary;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private List<Genre> genres = new ArrayList<>();
    @Range(min = 0, max = 10 , message = "{rate.range}")
    private double rate;
    private List<PersonRoleDTO> personRoles = new ArrayList<>();
    private String season;

    public List<VideoDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoDTO> videos) {
        this.videos = videos;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<PersonRoleDTO> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(List<PersonRoleDTO> personRoles) {
        this.personRoles = personRoles;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public static final class MediaItemDTOBuilder {
        private List<VideoDTO> videos;
        private String code;
        private @NotNull(message = "{notnull}") String title;
        private String summary;
        private LocalDate releaseDate;
        private List<Genre> genres;
        private @Range(min = 0, max = 10, message = "{rate.range}") double rate;
        private List<PersonRoleDTO> personRoles;
        private String season;

        private MediaItemDTOBuilder() {
        }

        public static MediaItemDTOBuilder aMediaItemDTO() {
            return new MediaItemDTOBuilder();
        }

        public MediaItemDTOBuilder withVideos(List<VideoDTO> videos) {
            this.videos = videos;
            return this;
        }

        public MediaItemDTOBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public MediaItemDTOBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public MediaItemDTOBuilder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public MediaItemDTOBuilder withReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MediaItemDTOBuilder withGenres(List<Genre> genres) {
            this.genres = genres;
            return this;
        }

        public MediaItemDTOBuilder withRate(double rate) {
            this.rate = rate;
            return this;
        }

        public MediaItemDTOBuilder withPersonRoles(List<PersonRoleDTO> personRoles) {
            this.personRoles = personRoles;
            return this;
        }

        public MediaItemDTOBuilder withSeason(String season) {
            this.season = season;
            return this;
        }

        public MediaItemDTO build() {
            MediaItemDTO mediaItemDTO = new MediaItemDTO();
            mediaItemDTO.setVideos(videos);
            mediaItemDTO.setCode(code);
            mediaItemDTO.setTitle(title);
            mediaItemDTO.setSummary(summary);
            mediaItemDTO.setReleaseDate(releaseDate);
            mediaItemDTO.setGenres(genres);
            mediaItemDTO.setRate(rate);
            mediaItemDTO.setPersonRoles(personRoles);
            mediaItemDTO.setSeason(season);
            return mediaItemDTO;
        }
    }
}
