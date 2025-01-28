package com.reyreey.filimo.DTO;

import com.reyreey.filimo.Model.Content.RoleType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/

public class PersonRoleDTO {
    @NotNull(message = "{notnull}")
    private String firstName;
    @NotNull(message = "{notnull}")
    private String lastName;
    private LocalDate dateOfBirth;
    @NotNull(message = "{notnull}")
    private RoleType roleType;

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

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + roleType + ")";
    }
}
