package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Repository.Content.ISeasonRepository;
import com.reyreey.filimo.Service.Content.Exceptions.DataNotFoundException;
import com.reyreey.filimo.Service.Content.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements ISeasonService {

    @Autowired
    private ISeasonRepository seasonRepository;

    @Override
    public List<Season> findAll() {
        return seasonRepository.findAll();

    }

    @Override
    public Season find(Long id) {
        var season = seasonRepository.findById(id);
        if(season.isEmpty()){
            throw new DataNotFoundException("Season not found");
        }
        return season.get();
    }

    @Override
    public Season insert(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public void change(Season season) {
        if(!seasonRepository.existsById(season.getId())){
            throw new DataNotFoundException("Season not found");
        }
        seasonRepository.save(season);
    }

    @Override
    public void remove(Long id) {
        if(!seasonRepository.existsById(id)){
            throw new DataNotFoundException("Season not found");
        }
        seasonRepository.deleteById(id);

    }

    @Override
    public List<Season> insertAll(List<Season> seasonList) {
        return seasonRepository.saveAll(seasonList);
    }
}
