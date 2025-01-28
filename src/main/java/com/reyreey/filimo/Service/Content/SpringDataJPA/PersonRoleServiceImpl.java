package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.PersonRole;
import com.reyreey.filimo.Repository.Content.IPersonRoleRepository;
import com.reyreey.filimo.Service.Content.Exceptions.DataNotFoundException;
import com.reyreey.filimo.Service.Content.IPersonRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

@Service
public class PersonRoleServiceImpl implements IPersonRoleService {

    @Autowired
    private IPersonRoleRepository personRoleRepository;

    @Override
    public List<PersonRole> findAll() {
        return personRoleRepository.findAll();
    }

    @Override
    public PersonRole find(Long id) {
        var personRole = personRoleRepository.findById(id);
        if (personRole.isEmpty()){
            throw new DataNotFoundException("PersonRole not found");
        }
        return personRole.get();
    }

    @Override
    public PersonRole insert(PersonRole personRole) {
        return personRoleRepository.save(personRole);
    }

    @Override
    public void change(PersonRole personRole) {
        if(!personRoleRepository.existsById(personRole.getId())){
            throw new DataNotFoundException("PersonRole not found");
        }
        personRoleRepository.save(personRole);
    }

    @Override
    public void remove(Long id) {
        if(!personRoleRepository.existsById(id)){
            throw new DataNotFoundException("PersonRole not found");
        }
        personRoleRepository.deleteById(id);
    }

    @Override
    public List<PersonRole> insertAll(List<PersonRole> personRoles) {

        return personRoleRepository.saveAll(personRoles);
    }
}
