package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.BaseEntity;
import com.reyreey.filimo.Model.People.Person;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "t_contentDetails")
public class ContentDetails extends BaseEntity {
    private Content content;
    private String code;
    private String title;
    private String summary;
    private LocalDate releasedate;
    private Set<Person> writers;
    private Person director;
    private Set<Person> actors;
    private double rate;
    private ContentType contentType;
    private Set<Genre> genres;

    @OneToOne(mappedBy = "content")
    @Column(name = "c_content", nullable = false)
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

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
    public LocalDate getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mm_contentDetails_writers",
            joinColumns = { @JoinColumn(name = "end1_id",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "end2_id",nullable = false) }
    )
    @OrderColumn(name = "idx")
    public Set<Person> getWriters() {
        return writers;
    }

    public void setWriters(Set<Person> writers) {
        this.writers = writers;
    }

    @ManyToOne
    @JoinColumn(name = "c_director",referencedColumnName = "id")
    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mm_contentDetails_actors",
            joinColumns = { @JoinColumn(name = "end1_id",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "end2_id",nullable = false) }
    )
    @OrderColumn(name = "idx")
    public Set<Person> getActors() {
        return actors;
    }

    public void setActors(Set<Person> actors) {
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mm_contentDetails_genres",
            joinColumns = { @JoinColumn(name = "end1_id",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "end2_id",nullable = false) }
    )
    @OrderColumn(name = "idx")
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
