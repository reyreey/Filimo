package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_person")
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Set<PersonRoleInMediaItem> personRoleInMediaItems;

    @Column(name = "c_firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "c_lastName")
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
    public Set<PersonRoleInMediaItem> getPersonRoleInMediaItems() {
        return personRoleInMediaItems;
    }

    public void setPersonRoleInMediaItems(Set<PersonRoleInMediaItem> personRoleInMediaItems) {
        this.personRoleInMediaItems = personRoleInMediaItems;
    }

    @Override
    public String toString() {
        return firstName +" "+ lastName +" "+ dateOfBirth;
    }
}
