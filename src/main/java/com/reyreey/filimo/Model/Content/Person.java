package com.reyreey.filimo.Model.Content;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_person"
//      ,  uniqueConstraints = {
//                @UniqueConstraint(name = "person",columnNames = {"c_firstName","c_lastName"})
//                }
                )
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @JsonIgnore
    private List<PersonRole> personRoles = new ArrayList<>();

    @Column(name = "c_firstName")
    @NotNull(message = "{notnull}")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "c_lastName")
    @NotNull(message = "{notnull}")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "c_dateOfBirth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @OneToMany(mappedBy = "person")
    public List<PersonRole> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(List<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private List<PersonRole> personRoles;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PersonBuilder withPersonRoles(List<PersonRole> personRoles) {
            this.personRoles = personRoles;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setDateOfBirth(dateOfBirth);
            person.setPersonRoles(personRoles);
            return person;
        }
    }
}
