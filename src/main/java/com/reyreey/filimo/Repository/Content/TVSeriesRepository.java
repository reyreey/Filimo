package com.reyreey.filimo.Repository.Content;


import com.reyreey.filimo.Model.Content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVSeriesRepository extends JpaRepository<Content, Long> {
}
