package com.reyreey.filimo.Model.People;

import com.reyreey.filimo.Model.Content.ContentDetail;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "t_writer")
public class Writer extends Person{
    private Set<ContentDetail> contentDetails;

    @ManyToMany(mappedBy = "writers")
    public Set<ContentDetail> getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(Set<ContentDetail> contentDetails) {
        this.contentDetails = contentDetails;
    }
}
