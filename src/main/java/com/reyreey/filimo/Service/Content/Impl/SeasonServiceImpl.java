package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Repository.Content.SeasonRepository;
import com.reyreey.filimo.Service.Content.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public List<Season> findAll() {
        return seasonRepository.findAll();

    }

    @Override
    public Season find(Long id) {
        var season = seasonRepository.findById(id);
        if(season.isEmpty()){
            //TODO data not found exception
            throw new RuntimeException("Season not found");
        }
        return season.get();
    }

    @Override
    public Boolean isExists(String title) {
        return seasonRepository.existsByTitle(title);
    }

    @Override
    public void insert(Season season) {
        seasonRepository.save(season);
    }

    @Override
    public void change(Season season) {
        if(!seasonRepository.existsById(season.getId())){
            //TODO data not found exception
            throw new RuntimeException("Season not found");
        }
        seasonRepository.save(season);
    }

    @Override
    public void remove(Long id) {
        if(!seasonRepository.existsById(id)){
            //TODO data not found exception
            throw new RuntimeException("Season not found");
        }
        seasonRepository.deleteById(id);

    }
}
