package com.reyreey.filimo.Utill.CSVToDTO.DTO;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/14/2025, Tuesday
 **/

public class PersonDTO {
    @CsvBindByName(column = "FirstName")
    private String firstName;
    @CsvBindByName(column = "LastName")
    private String lastName;
    @CsvBindByName(column = "DateOfBirth")
    @CsvDate("yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return firstName +" "+ lastName +" "+ dateOfBirth ;
    }
}
