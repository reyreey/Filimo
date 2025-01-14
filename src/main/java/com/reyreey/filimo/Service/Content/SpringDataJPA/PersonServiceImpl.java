package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.Person;
import com.reyreey.filimo.Repository.Content.IPersonRepository;
import com.reyreey.filimo.Service.Content.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

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

    @Override
    public Person findByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    @Override
    public List<Person> findByLastNameLike(String lastName) {
        return personRepository.findByLastNameLike(lastName);
    }
}
