package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.TVSeries;
import com.reyreey.filimo.Repository.Content.ITVSeriesRepository;
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
            //TODO data not found exception
            throw new RuntimeException("TVSeries not found");
        }
        return tvSeries.get();
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
