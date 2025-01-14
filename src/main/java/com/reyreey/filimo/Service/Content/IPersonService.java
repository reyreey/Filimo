package com.reyreey.filimo.Service.Content;

import com.reyreey.filimo.Model.Content.Person;

import java.util.List;

public interface IPersonService extends ICrudService<Person> {
    Person findByLastName(String lastName);
    List<Person> findByLastNameLike(String lastName);
}
