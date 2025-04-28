package com.reyreey.filimo.Model.Content.Builder;

import com.reyreey.filimo.Model.Content.ContentDetail;

import java.time.LocalDate;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 4/28/2025, Monday
 **/

public final class ContentDetailBuilder {
    private LocalDate releaseDate;
    private String summary;
    private String title;
    private String code;

    private ContentDetailBuilder() {
    }

    public static ContentDetailBuilder aContentDetail() {
        return new ContentDetailBuilder();
    }

    public ContentDetailBuilder withReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public ContentDetailBuilder withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public ContentDetailBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContentDetailBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public ContentDetail build() {
        ContentDetail contentDetail = new ContentDetail();
        contentDetail.setReleaseDate(releaseDate);
        contentDetail.setSummary(summary);
        contentDetail.setTitle(title);
        contentDetail.setCode(code);
        return contentDetail;
    }
}
