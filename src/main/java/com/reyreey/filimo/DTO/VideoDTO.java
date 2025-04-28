package com.reyreey.filimo.DTO;

import com.reyreey.filimo.Model.Content.Quality;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/

public class VideoDTO {
    @URL(message = "{url}")
    @NotNull(message = "{notnull}")
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

    public static final class VideoDTOBuilder {
        private @URL(message = "{url}")
        @NotNull(message = "{notnull}") String url;
        private Quality quality;

        private VideoDTOBuilder() {
        }

        public static VideoDTOBuilder aVideoDTO() {
            return new VideoDTOBuilder();
        }

        public VideoDTOBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public VideoDTOBuilder withQuality(Quality quality) {
            this.quality = quality;
            return this;
        }

        public VideoDTO build() {
            VideoDTO videoDTO = new VideoDTO();
            videoDTO.setUrl(url);
            videoDTO.setQuality(quality);
            return videoDTO;
        }
    }
}
