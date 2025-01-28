package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.TVSeries;
import com.reyreey.filimo.Repository.Content.ITVSeriesRepository;
import com.reyreey.filimo.Service.Content.Exceptions.DataNotFoundException;
import com.reyreey.filimo.Service.Content.ITVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVSeriesServiceImpl implements ITVSeriesService {

    @Autowired
    private ITVSeriesRepository tvSeriesRepository;

    @Override
    public List<TVSeries> findAll() {
        return tvSeriesRepository.findAll();
    }

    @Override
    public TVSeries find(Long id) {
        var tvSeries = tvSeriesRepository.findById(id);
        if(tvSeries.isEmpty()) {
            throw new DataNotFoundException("TVSeries not found");
        }
        return tvSeries.get();
    }

    @Override
    public TVSeries insert(TVSeries tvSeries) {
        return tvSeriesRepository.save(tvSeries);
    }

    @Override
    public void change(TVSeries tvSeries) {
        if(!tvSeriesRepository.existsById(tvSeries.getId())){
            throw new DataNotFoundException("TVSeries not found");
        }
        tvSeriesRepository.save(tvSeries);
    }

    @Override
    public void remove(Long id) {
        if(!tvSeriesRepository.existsById(id)){
            throw new DataNotFoundException("TVSeries not found");
        }
        tvSeriesRepository.deleteById(id);

    }

    @Override
    public List<TVSeries> insertAll(List<TVSeries> tvSeriesList) {
        return tvSeriesRepository.saveAll(tvSeriesList);
    }
}
