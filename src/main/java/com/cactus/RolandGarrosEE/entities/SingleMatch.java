package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SINGLEMATCH")
public class SingleMatch extends Match implements Serializable {
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE} , mappedBy = "matchsSingle", fetch = FetchType.LAZY)
    @Size(min=2, max=2)
    private Set<Player> playersList;

    public SingleMatch() {
    }

    public SingleMatch(Date dateEnd, Date dateBegin, int scoreA, int scoreB, Tournament tournament, Court court, Referee referee, Set<Player> playersList) {
        super(dateEnd, dateBegin, scoreA, scoreB, tournament, court, referee);
        this.playersList = playersList;
    }

    public Set<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(Set<Player> playersList) {
        this.playersList = playersList;
    }
}
