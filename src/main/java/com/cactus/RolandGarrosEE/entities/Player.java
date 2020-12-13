package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PLAYER")
public class Player extends Member implements Serializable {
    @Column(name = "RANKINGS", unique = true)
    private int rankings;
    @NotNull
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name="player_singlematch",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "singlematch_id"))
    private List<SingleMatch> matchsSingle;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "playersList")
    @Size(min=0, max=2)
    private List<Team> teamsList;

    public Player() {
    }

    public Player(int rankings, @NotNull Gender gender, List<SingleMatch> matchsSingle, @Size(min = 0, max = 2) List<Team> teamsList) {
        this.rankings = rankings;
        this.gender = gender;
        this.matchsSingle = matchsSingle;
        this.teamsList = teamsList;
    }

    public Player(String firstname, String lastname, String nationality, int rankings, @NotNull Gender gender, List<SingleMatch> matchsSingle, @Size(min = 0, max = 2) List<Team> teamsList) {
        super(firstname, lastname, nationality);
        this.rankings = rankings;
        this.gender = gender;
        this.matchsSingle = matchsSingle;
        this.teamsList = teamsList;
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

    public List<Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
    }
}
