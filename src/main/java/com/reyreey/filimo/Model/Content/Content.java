package com.reyreey.filimo.Model.Content;

import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Content extends BaseEntity {

    abstract public void play();
    abstract public void setEnable();
    abstract public void setDisable();
    abstract public void confirm();

}
