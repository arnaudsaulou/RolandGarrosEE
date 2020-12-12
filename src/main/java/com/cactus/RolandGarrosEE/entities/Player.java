package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PLAYER")
public class Player extends Member implements Serializable {
    @Nullable
    @Column(name = "CLASSEMENT", unique = true)
    private int classement;
    @NotNull
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<SingleMatch> matchsSingle;
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<DoubleMatch> matchsDouble;
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Team> teams;

    public Player() {
    }

    public Player(int classement, Gender gender, List<SingleMatch> matchsSingle, List<DoubleMatch> matchsDouble, List<Team> teams) {
        this.classement = classement;
        this.gender = gender;
        this.matchsSingle = matchsSingle;
        this.matchsDouble = matchsDouble;
        this.teams = teams;
    }

    public Player(String firstname, String lastname, String nationality, int classement, Gender gender, List<SingleMatch> matchsSingle, List<DoubleMatch> matchsDouble, List<Team> teams) {
        super(firstname, lastname, nationality);
        this.classement = classement;
        this.gender = gender;
        this.matchsSingle = matchsSingle;
        this.matchsDouble = matchsDouble;
        this.teams = teams;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<SingleMatch> getMatchsSingle() {
        return matchsSingle;
    }

    public void setMatchsSingle(List<SingleMatch> matchsSingle) {
        this.matchsSingle = matchsSingle;
    }

    public List<DoubleMatch> getMatchsDouble() {
        return matchsDouble;
    }

    public void setMatchsDouble(List<DoubleMatch> matchsDouble) {
        this.matchsDouble = matchsDouble;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
