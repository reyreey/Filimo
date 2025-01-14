package com.reyreey.filimo.Repository.Content;

import com.reyreey.filimo.Model.Content.Person;

import java.util.List;

public interface IPersonRepository extends IGenericRepository<Person> {
    Person findByFullName(String fullName);
    Person findByLastName(String lastName);
    List<Person> findByLastNameLike(String lastName);
}
