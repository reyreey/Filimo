package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Repository.Content.ISeasonRepository;
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
            //TODO data not found exception
            throw new RuntimeException("Season not found");
        }
        return season.get();
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
