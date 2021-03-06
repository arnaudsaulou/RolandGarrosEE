package com.cactus.RolandGarrosEE.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PLAYER")
public class Player extends Member implements Serializable {
    @Column(name = "RANKINGS")
    private Integer rankings;
    @NotNull
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "playersList", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SingleMatch> matchsSingle;

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "playersList", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Size(min=0, max=2)
    private Set<Team> teamsList;

    public Player() {
    }

    public Player(int rankings, @NotNull Gender gender, List<SingleMatch> matchsSingle, @Size(min = 0, max = 2) Set<Team> teamsList) {
        this.rankings = rankings;
        this.gender = gender;
        this.matchsSingle = matchsSingle;
        this.teamsList = teamsList;
    }

    public Player(String firstname, String lastname, String nationality, int rankings, @NotNull Gender gender, List<SingleMatch> matchsSingle, @Size(min = 0, max = 2) Set<Team> teamsList) {
        super(firstname, lastname, nationality);
        this.rankings = rankings;
        this.gender = gender;
        this.matchsSingle = matchsSingle;
        this.teamsList = teamsList;
    }

    public Player(String firstname, String lastname, String nationality, int rankings, @NotNull Gender gender) {
        super(firstname, lastname, nationality);
        this.rankings = rankings;
        this.gender = gender;
    }

    public int getRankings() {
        return rankings;
    }

    public void setRankings(int rankings) {
        this.rankings = rankings;
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

    public Set<Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(Set<Team> teamsList) {
        this.teamsList = teamsList;
    }
}
