package com.reyreey.filimo.Service.Content;

import java.util.List;

public interface ICrudService<T>{

    List<T> findAll();
    T find(Long id);
    void insert(T t);
    void change(T t);
    void remove(Long id);
}
