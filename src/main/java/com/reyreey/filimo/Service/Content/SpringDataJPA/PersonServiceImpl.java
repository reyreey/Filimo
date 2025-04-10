package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.Person;
import com.reyreey.filimo.Repository.Content.IPersonRepository;
import com.reyreey.filimo.Service.Content.Exceptions.DataNotFoundException;
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
            throw new DataNotFoundException("Person not found");
        }
        return person.get();
    }

    @Override
    public Person insert(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void change(Person person) {
        if(!personRepository.existsById(person.getId())){
            throw new DataNotFoundException("Person not found");
        }
        personRepository.save(person);
    }

    @Override
    public void remove(Long id) {
        if(!personRepository.existsById(id)){
            throw new DataNotFoundException("Person not found");
        }
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> insertAll(List<Person> personList) {
        return personRepository.saveAll(personList);
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
