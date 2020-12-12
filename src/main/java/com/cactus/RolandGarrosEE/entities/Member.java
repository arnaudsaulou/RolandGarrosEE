package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Member implements Serializable {
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
    @Column(name="NATIONALITY")
    private String nationality;

    public Member(){
    }

    public Member(String firstname, String lastname, String nationality) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationality = nationality;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
