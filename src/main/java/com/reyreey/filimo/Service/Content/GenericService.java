package com.reyreey.filimo.Service.Content;

import java.util.List;

public interface GenericService <T>{
    List<T> findAll();
    T find(Long id);
    Boolean isExists(String title);
    void insert(T t);
    void change(T t);
    void remove(Long id);
}
