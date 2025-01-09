package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "t_personRoleInMediaItem")
public class PersonRoleInMediaItem extends BaseEntity {
    private Person  person;
    private MediaItem  mediaItem;
    private RoleType roleType;

    @ManyToOne
    @JoinColumn(name = "c_person", referencedColumnName = "id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToOne
    @JoinColumn(name = "c_mediaItem", referencedColumnName = "id")
    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    @Column(name = "c_roleType")
    @Enumerated(EnumType.STRING)
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
