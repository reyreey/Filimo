package com.reyreey.filimo.Controller.Content.api;

import com.reyreey.filimo.DTO.TVSeriesDTO;
import com.reyreey.filimo.Model.Content.TVSeries;
import com.reyreey.filimo.Service.Content.ITVSeriesService;
import com.reyreey.filimo.Service.Content.Impl.TVSeriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/28/2025, Tuesday
 **/
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class TVSeriesController {
    @Autowired
    private TVSeriesService tvSeriesService;

    @Autowired
    private ITVSeriesService itvSeriesService;

    @PostMapping(path = "/add-tvSeries")
    public ResponseEntity<TVSeriesDTO> createTVSeries(@Valid @RequestBody TVSeriesDTO tvSeriesDTO){

        TVSeriesDTO createdTVSeries = tvSeriesService.createTVSeries(tvSeriesDTO);

        return ResponseEntity.ok(createdTVSeries);
    }

    @PostMapping(path = "/add-tvSeriesList")
    public ResponseEntity<List<TVSeriesDTO>> createTVSeriesList(@Valid @RequestBody List<TVSeriesDTO> tvSeriesDTOs){

        List<TVSeriesDTO> createdTVSeries = tvSeriesService.createTVSeriesList(tvSeriesDTOs);

        return ResponseEntity.ok(createdTVSeries);
    }

    @GetMapping(path = "/tvSeries/all")
    public List<TVSeries> getAllTVSeries(){
        return itvSeriesService.findAll();
    }
}
