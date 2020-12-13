package com.cactus.RolandGarrosEE.entities;


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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name="ID")
    private int id;
    @NotNull
    @Column(name="NAME")
    private String name;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="team_player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    @Size(min=2, max=2)
    private Set<Player> playersList;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "teamsList", fetch = FetchType.LAZY)
    private Set<DoubleMatch> matchsDouble;

    public Team(){
    }

    public Team(@NotNull int id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Team(@NotNull int id, @NotNull String name, @Size(min = 2, max = 2) Set<Player> playersList, Set<DoubleMatch> matchsDouble) {
        this.id = id;
        this.name = name;
        this.playersList = playersList;
        this.matchsDouble = matchsDouble;
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

    public Set<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(Set<Player> playersList) {
        this.playersList = playersList;
    }

    public Set<DoubleMatch> getMatchsDouble() {
        return matchsDouble;
    }

    public void setMatchsDouble(Set<DoubleMatch> matchsDouble) {
        this.matchsDouble = matchsDouble;
    }
}
