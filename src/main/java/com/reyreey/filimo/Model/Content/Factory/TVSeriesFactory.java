package com.reyreey.filimo.Model.Content.Factory;

import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Model.Content.TVSeries;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/28/2025, Tuesday
 **/

public class TVSeriesFactory {
    public static TVSeries createTVSeries(List<Season> seasons, boolean isFinished, ContentDetail contentDetail) {
        TVSeries tvSeries = new TVSeries();

        tvSeries.setSeasons(seasons);
        tvSeries.setFinished(isFinished);
        tvSeries.setDetail(contentDetail);


        return tvSeries;
    }
}
