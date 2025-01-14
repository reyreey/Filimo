package com.reyreey.filimo.Repository.Content;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IGenericRepository<T> extends JpaRepository<T,Long> {

}
