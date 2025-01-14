package com.reyreey.filimo.Repository.Content;

import com.reyreey.filimo.Model.Content.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonRepository extends JpaRepository<Person,Long> {
    Person findByLastName(String lastName);
    List<Person> findByLastNameLike(String lastName);
}
