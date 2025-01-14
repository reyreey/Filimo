package com.reyreey.filimo.Utill.CSVToDTO.Mapper;

import com.reyreey.filimo.Model.Content.Person;
import com.reyreey.filimo.Utill.CSVToDTO.DTO.PersonDTO;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

public class PersonMapper {

    public static Person mapToEntity(PersonDTO dto) {
        Person entity = new Person();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;
    }
}
