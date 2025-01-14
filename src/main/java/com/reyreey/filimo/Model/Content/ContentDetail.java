package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "t_contentDetails")
public class ContentDetail extends BaseEntity {
    private String code;
    private String title;
    private String summary;
    private LocalDate releaseDate;

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

}
