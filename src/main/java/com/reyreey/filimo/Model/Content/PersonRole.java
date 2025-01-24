package com.reyreey.filimo.Model.Content;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 1/17/2025, Friday
 **/
@Entity
@Table(name = "t_personRole",
        uniqueConstraints = {
                @UniqueConstraint(name = "personRole",columnNames = {"c_person","c_roleType"})
        })
public class PersonRole extends BaseEntity {
    private Person  person;
    private RoleType roleType;
    @JsonIgnore
    private List<MediaItem> mediaItemList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "c_person", referencedColumnName = "id")
//    @NotNull(message = "{notnull}")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "c_roleType")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{notnull}")
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    @ManyToMany(mappedBy = "personRoles")
    public List<MediaItem> getMediaItemList() {
        return mediaItemList;
    }

    public void setMediaItemList(List<MediaItem> mediaItemList) {
        this.mediaItemList = mediaItemList;
    }

    @Override
    public String toString() {
        return "PersonRole{" +
                "person=" + person +
                ", roleType=" + roleType +
                '}';
    }
}
