package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.Person;
import com.reyreey.filimo.Repository.Content.PersonRepository;
import com.reyreey.filimo.Service.Content.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person find(Long id) {
        var person = personRepository.findById(id);
        if(person.isEmpty()){
            //TODO data not found exception
            throw new RuntimeException("Person not found");
        }
        return person.get();
    }

    @Override
    public Boolean isExists(String title) {
        return personRepository.existsByTitle(title);
    }

    @Override
    public void insert(Person person) {
        personRepository.save(person);
    }

    @Override
    public void change(Person person) {
        if(!personRepository.existsById(person.getId())){
            //TODO data not found exception
            throw new RuntimeException("Person not found");
        }
        personRepository.save(person);
    }

    @Override
    public void remove(Long id) {
        if(!personRepository.existsById(id)){
            //TODO data not found exception
            throw new RuntimeException("Person not found");
        }
        personRepository.deleteById(id);
    }
}
