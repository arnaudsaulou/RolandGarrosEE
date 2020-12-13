package com.cactus.RolandGarrosEE.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name="team_player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    @Size(min=2, max=2)
    private List<Player> playersList;
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, mappedBy = "teamsList")
    private List<DoubleMatch> matchsDouble;

    public Team(@NotNull int id, @NotNull String name, @Size(min = 2, max = 2) List<Player> playersList, List<DoubleMatch> matchsDouble) {
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

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public List<DoubleMatch> getMatchsDouble() {
        return matchsDouble;
    }

    public void setMatchsDouble(List<DoubleMatch> matchsDouble) {
        this.matchsDouble = matchsDouble;
    }
}
