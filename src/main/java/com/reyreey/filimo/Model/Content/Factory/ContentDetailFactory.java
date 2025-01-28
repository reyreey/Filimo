package com.reyreey.filimo.Model.Content.Factory;

import com.reyreey.filimo.Model.Content.ContentDetail;

import java.time.LocalDate;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/28/2025, Tuesday
 **/

public class ContentDetailFactory {

    public static ContentDetail createContentDetail(String code,String title, String summary, LocalDate releaseDate) {
        ContentDetail contentDetail = new ContentDetail();
        contentDetail.setCode(code);
        contentDetail.setTitle(title);
        contentDetail.setSummary(summary);
        contentDetail.setReleaseDate(releaseDate);

        return contentDetail;
    }
}
