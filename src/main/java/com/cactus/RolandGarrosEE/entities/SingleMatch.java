package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SINGLEMATCH")
public class SingleMatch extends Match implements Serializable {

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @Size(min=2, max=2)
    @JoinTable(name="player_singlematch",
            joinColumns = @JoinColumn(name = "singlematch_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> playersList;

    public SingleMatch() {
    }

    public SingleMatch(Date dateBegin, Date dateEnd, int scoreA, int scoreB, Tournament tournament, Court court, Referee referee, List<Player> playersList) {
        super(dateBegin, dateEnd, scoreA, scoreB, tournament, court, referee);
        this.playersList = playersList;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

}
