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
@Table(name = "TEAM")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID")
    private int id;
    @NotNull
    @Column(name = "NAME")
    private String name;
    @NotNull
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "team_player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    @Size(min = 2, max = 2)
    private List<Player> playersList;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "teamsList", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<DoubleMatch> doubleMatches;

    public Team() {
    }

    public Team(@NotNull int id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Team(@NotNull int id, @NotNull String name, @NotNull Gender gender, @Size(min = 2, max = 2) List<Player> playersList) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.playersList = playersList;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public List<DoubleMatch> getDoubleMatches() {
        return doubleMatches;
    }

    public void setDoubleMatches(List<DoubleMatch> doubleMatches) {
        this.doubleMatches = doubleMatches;
    }
}
