package com.reyreey.filimo.Repository.Content;


import com.reyreey.filimo.Model.Content.TVSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITVSeriesRepository extends JpaRepository<TVSeries,Long> {
}
