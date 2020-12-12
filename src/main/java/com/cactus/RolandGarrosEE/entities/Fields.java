package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "FIELD")
public class Fields {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name="ID")
    private int id;
    @NotNull
    @Column(name="NAME")
    private String name;

    public Fields(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
