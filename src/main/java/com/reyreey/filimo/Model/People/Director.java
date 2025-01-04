package com.reyreey.filimo.Model.People;

import com.reyreey.filimo.Model.Content.Content;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "t_director")
public class Director extends Person{
    private Set<Content> contents;

    @OneToMany(mappedBy = "director")
    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

}
