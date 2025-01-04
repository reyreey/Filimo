package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.BaseEntity;
import com.reyreey.filimo.Model.People.Actor;
import com.reyreey.filimo.Model.People.Person;
import com.reyreey.filimo.Model.People.Writer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "t_contentDetails")
public class ContentDetail extends BaseEntity {
    private String code;
    private String title;
    private String summary;
    private LocalDate releaseDate;
    private Set<Writer> writers;
    private Set<Actor> actors;
    private double rate;
    private ContentType contentType;


    @Column(name = "c_code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "c_title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "c_summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "c_releaseDate")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releasedate) {
        this.releaseDate = releasedate;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mm_contentDetail_writer",
            joinColumns = { @JoinColumn(name = "contentDetail_id",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "writer_id",nullable = false) }
    )
    @OrderColumn(name = "idx")
    public Set<Writer> getWriters() {
        return writers;
    }

    public void setWriters(Set<Writer> writers) {
        this.writers = writers;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mm_contentDetail_actor",
            joinColumns = { @JoinColumn(name = "contentDetail_id",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "actor_id",nullable = false) }
    )
    @OrderColumn(name = "idx")
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Column(name = "c_rate")
    public double getRate() {
        return rate;
    }

    public void setRate(double rating) {
        this.rate = rating;
    }

    @Column(name = "c_contentType")
    @Enumerated(EnumType.STRING)
    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }
}
