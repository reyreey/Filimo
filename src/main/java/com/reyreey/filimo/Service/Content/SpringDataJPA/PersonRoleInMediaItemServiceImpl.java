package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.PersonRoleInMediaItem;
import com.reyreey.filimo.Repository.Content.IPersonRoleInMediaItemRepository;
import com.reyreey.filimo.Service.Content.IPersonRoleInMediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

@Service
public class PersonRoleInMediaItemServiceImpl implements IPersonRoleInMediaItemService {

    @Autowired
    private IPersonRoleInMediaItemRepository personRoleInMediaItemRepository;

    @Override
    public List<PersonRoleInMediaItem> findAll() {
        return personRoleInMediaItemRepository.findAll();
    }

    @Override
    public PersonRoleInMediaItem find(Long id) {
        var personRoleInMediaItem = personRoleInMediaItemRepository.findById(id);
        if (personRoleInMediaItem.isEmpty()){
            //TODO data not found exception
            throw new RuntimeException("PersonRoleInMediaItem not found");
        }
        return personRoleInMediaItem.get();
    }

    @Override
    public void insert(PersonRoleInMediaItem personRoleInMediaItem) {
        personRoleInMediaItemRepository.save(personRoleInMediaItem);
    }

    @Override
    public void change(PersonRoleInMediaItem personRoleInMediaItem) {
        if(!personRoleInMediaItemRepository.existsById(personRoleInMediaItem.getId())){
            //TODO data not found exception
            throw new RuntimeException("PersonRoleInMediaItem not found");
        }
        personRoleInMediaItemRepository.save(personRoleInMediaItem);
    }

    @Override
    public void remove(Long id) {
        if(!personRoleInMediaItemRepository.existsById(id)){
            //TODO data not found exception
            throw new RuntimeException("PersonRoleInMediaItem not found");
        }
        personRoleInMediaItemRepository.deleteById(id);
    }
}
