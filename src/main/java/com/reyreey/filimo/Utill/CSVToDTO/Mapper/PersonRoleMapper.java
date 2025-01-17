package com.reyreey.filimo.Utill.CSVToDTO.Mapper;

import com.reyreey.filimo.Model.Content.Person;
import com.reyreey.filimo.Model.Content.PersonRole;
import com.reyreey.filimo.Utill.CSVToDTO.DTO.PersonRoleDTO;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/

public class PersonRoleMapper {
    public static PersonRole mapToEntity(PersonRoleDTO dto) {
        PersonRole entity = new PersonRole();

        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setDateOfBirth(dto.getDateOfBirth());

        entity.setPerson(person);
        entity.setRoleType(dto.getRoleType());

        return entity;
    }

    public static PersonRoleDTO mapToDTO(PersonRole entity) {
        PersonRoleDTO dto = new PersonRoleDTO();

        dto.setFirstName(entity.getPerson().getFirstName());
        dto.setLastName(entity.getPerson().getLastName());
        dto.setDateOfBirth(entity.getPerson().getDateOfBirth());

        dto.setRoleType(entity.getRoleType());

        return dto;
    }
}
