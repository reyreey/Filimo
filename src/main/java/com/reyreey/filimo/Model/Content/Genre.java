package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_genres")
public class Genre extends BaseEntity {

    private String name;

    @Column(name = "c_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
