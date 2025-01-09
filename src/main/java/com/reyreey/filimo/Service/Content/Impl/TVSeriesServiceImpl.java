package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.TVSeries;
import com.reyreey.filimo.Repository.Content.TVSeriesRepository;
import com.reyreey.filimo.Service.Content.TVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVSeriesServiceImpl implements TVSeriesService {

    @Autowired
    private TVSeriesRepository tvSeriesRepository;

    @Override
    public List<TVSeries> findAll() {
        return tvSeriesRepository.findAll();
    }

    @Override
    public TVSeries find(Long id) {
        var tvSeries = tvSeriesRepository.findById(id);
        if(tvSeries.isEmpty()) {
            //TODO data not found exception
            throw new RuntimeException("TVSeries not found");
        }
        return tvSeries.get();
    }

    @Override
    public Boolean isExists(String title) {
        return tvSeriesRepository.existsByTitle(title);
    }

    @Override
    public void insert(TVSeries tvSeries) {
        tvSeriesRepository.save(tvSeries);
    }

    @Override
    public void change(TVSeries tvSeries) {
        if(!tvSeriesRepository.existsById(tvSeries.getId())){
            //TODO data not found exception
            throw new RuntimeException("TVSeries not found");
        }
        tvSeriesRepository.save(tvSeries);
    }

    @Override
    public void remove(Long id) {
        if(!tvSeriesRepository.existsById(id)){
            //TODO data not found exception
            throw new RuntimeException("TVSeries not found");
        }
        tvSeriesRepository.deleteById(id);

    }
}
