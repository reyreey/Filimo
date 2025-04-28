package com.reyreey.filimo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reyreey.filimo.Model.Content.RoleType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonRoleDTO {
    @NotNull(message = "{notnull}")
    private String firstName;
    @NotNull(message = "{notnull}")
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

    public static final class PersonRoleDTOBuilder {
        private @NotNull(message = "{notnull}") String firstName;
        private @NotNull(message = "{notnull}") String lastName;
        private LocalDate dateOfBirth;
        private @NotNull(message = "{notnull}") RoleType roleType;

        private PersonRoleDTOBuilder() {
        }

        public static PersonRoleDTOBuilder aPersonRoleDTO() {
            return new PersonRoleDTOBuilder();
        }

        public PersonRoleDTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonRoleDTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonRoleDTOBuilder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PersonRoleDTOBuilder withRoleType(RoleType roleType) {
            this.roleType = roleType;
            return this;
        }

        public PersonRoleDTO build() {
            PersonRoleDTO personRoleDTO = new PersonRoleDTO();
            personRoleDTO.setFirstName(firstName);
            personRoleDTO.setLastName(lastName);
            personRoleDTO.setDateOfBirth(dateOfBirth);
            personRoleDTO.setRoleType(roleType);
            return personRoleDTO;
        }
    }
}
