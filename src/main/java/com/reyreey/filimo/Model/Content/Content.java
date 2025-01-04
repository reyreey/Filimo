package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.BaseEntity;
import com.reyreey.filimo.Model.Comment;
import com.reyreey.filimo.Model.People.Director;
import com.reyreey.filimo.Model.People.Producer;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_content")
public abstract class Content extends BaseEntity {

    private Set<Genre> genres;
    private Set<Comment> comments;
    private Director director;
    private Producer producer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mm_content_genre",
            joinColumns = { @JoinColumn(name = "content_id",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "genre_id",nullable = false) }
    )
    @OrderColumn(name = "idx")
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @OneToMany
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "c_director",referencedColumnName = "id")
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @ManyToOne
    @JoinColumn(name = "c_producer", referencedColumnName = "id")
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    abstract public void play();
    abstract public void setEnable();
    abstract public void setDisable();
    abstract public void confirm();

}
