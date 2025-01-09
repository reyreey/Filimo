package com.reyreey.filimo.Repository.Content;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T> extends JpaRepository<T,Long> {
    boolean existsByTitle(String title);
    T findByTitle(String title);
}
