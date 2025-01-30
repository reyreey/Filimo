package com.reyreey.filimo.Controller.Content.api;

import com.reyreey.filimo.DTO.SeasonDTO;
import com.reyreey.filimo.Model.Content.MediaItem;
import com.reyreey.filimo.Model.Content.Season;
import com.reyreey.filimo.Service.Content.ISeasonService;
import com.reyreey.filimo.Service.Content.Impl.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/20/2025, Monday
 **/

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SeasonController {
    @Autowired
    private SeasonService seasonService;

    @Autowired
    private ISeasonService iSeasonService;

    @PostMapping(path = "/add-season")
    public ResponseEntity<SeasonDTO> createSeason(@RequestBody SeasonDTO seasonDTO,@PathVariable Long tvSeriesID){

        SeasonDTO createdSeason = seasonService.createSeason(seasonDTO,tvSeriesID);

        return ResponseEntity.ok(createdSeason);
    }

    @PostMapping(path = "/add-seasons")
    public ResponseEntity<List<SeasonDTO>> createSeasons(@RequestBody List<SeasonDTO> seasonDTOs,@PathVariable Long tvSeriesID){

        List<SeasonDTO> createdSeason = seasonService.createSeasons(seasonDTOs,tvSeriesID);

        return ResponseEntity.ok(createdSeason);
    }

    @GetMapping(path = "/seasons/all")
    public List<Season> getAllSeasons(){
        return iSeasonService.findAll();
    }

}
