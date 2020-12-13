package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SINGLEMATCH")
public class SingleMatch extends Match implements Serializable {
    @ManyToOne(targetEntity=Player.class)
    private Player playerA;
    @ManyToOne(targetEntity=Player.class)
    private Player playerB;

    public SingleMatch() {
    }

    public SingleMatch(Date dateEnd, Date dateBegin, int scoreA, int scoreB, Tournament tournament, Fields fields, Referee referee) {
        super(dateEnd, dateBegin, scoreA, scoreB, tournament, fields, referee);
    }

    public Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }
}
