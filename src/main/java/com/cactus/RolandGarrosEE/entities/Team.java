package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name="ID")
    private int id;
    @NotNull
    @Column(name="NAME")
    private String name;
    @ManyToOne
    private Player playerA;
    @ManyToOne
    private Player playerB;
}
