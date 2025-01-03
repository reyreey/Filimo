package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.BaseEntity;
import jakarta.persistence.*;

@Entity
public abstract class Content extends BaseEntity {

    private ContentDetails details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_details",referencedColumnName = "id")
    public ContentDetails getDetails() {
        return details;
    }

    public void setDetails(ContentDetails details) {
        this.details = details;
    }

    abstract public void play();
    abstract public void setEnable();
    abstract public void setDisable();
    abstract public void confirm();

}
