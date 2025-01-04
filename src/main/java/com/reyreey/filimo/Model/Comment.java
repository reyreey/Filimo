package com.reyreey.filimo.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_comment")
public class Comment extends BaseEntity {

    private String comment;
    private User author;
    private LocalDateTime dateTime;
    private boolean isConfirmed;

    @Column(name = "c_comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "c_author" , referencedColumnName = "id")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Column(name = "c_dateTime")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "c_isConfirmed" )
    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
