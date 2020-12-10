package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name="ID")
    private int id;
    @NotNull
    @Column(name="FIRSTNAME")
    private String firstname;
    @NotNull
    @Column(name="LASTNAME")
    private String lastname;
    @NotNull
    @Column(name="MAIL", unique = true)
    private String mail;
    @NotNull
    @Column(name="PASSWORD")
    private String password;
    @NotNull
    @Column(name="STATUS")
    private int status;

    public User() {
    }

    public User(String firstname, String lastname, String mail, String password, int status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
