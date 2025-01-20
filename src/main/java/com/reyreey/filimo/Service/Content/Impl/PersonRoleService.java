package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.DTO.PersonRoleDTO;
import com.reyreey.filimo.Model.Content.PersonRole;
import com.reyreey.filimo.Repository.Content.IPersonRoleRepository;
import com.reyreey.filimo.Service.Content.IPersonService;
import com.reyreey.filimo.Utill.CSVToDTO.Mapper.PersonRoleMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/20/2025, Monday
 **/
@Service
public class PersonRoleService {

    @Autowired
    private IPersonRoleRepository personRoleRepository;

    @Autowired
    private IPersonService personService;

    @Transactional
    public PersonRoleDTO createPersonRole(PersonRoleDTO personRoleDTO){

        PersonRole personRole = PersonRoleMapper.mapToEntity(personRoleDTO);

        personService.insert(personRole.getPerson());

        return PersonRoleMapper.mapToDTO(personRoleRepository.save(personRole));
    }

    @Transactional
    public List<PersonRoleDTO> createPersonRoles(List<PersonRoleDTO> personRoleDTOs) {

        List<PersonRole> personRoles = personRoleDTOs.stream().map(PersonRoleMapper::mapToEntity).toList();

        for (PersonRole personRole : personRoles){
            personService.insert(personRole.getPerson());
        }

        List<PersonRoleDTO> createdPersonRoleDTOs = personRoleRepository.saveAll(personRoles).stream().map(PersonRoleMapper::mapToDTO).toList();

        return createdPersonRoleDTOs;
    }
}
