package com.reyreey.filimo.Service.Content;

import com.reyreey.filimo.Model.Content.PersonRole;

import java.util.List;

public interface ICrudService<T>{

    List<T> findAll();
    T find(Long id);
    T insert(T t);
    void change(T t);
    void remove(Long id);

    List<T> insertAll(List<T> t);
}
