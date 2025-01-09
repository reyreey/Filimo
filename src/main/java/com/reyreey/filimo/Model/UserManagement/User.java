package com.reyreey.filimo.Model.UserManagement;

import com.reyreey.filimo.Model.Common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_user")
public class User extends BaseEntity {
    private String username;
    private String password;

    @Column(name = "c_username" , nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "c_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
