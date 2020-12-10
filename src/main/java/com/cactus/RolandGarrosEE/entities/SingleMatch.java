package com.cactus.RolandGarrosEE.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SINGLEMATCH")
public class SingleMatch extends Match{
    @ManyToOne
    private Player playerA;
    @ManyToOne
    private Player playerB;

    public SingleMatch() {
    }

    public SingleMatch(Date time, Date date, int scoreA, int scoreB, Tournament tournament, Fields fields, Arbitrator arbitrator) {
        super(time, date, scoreA, scoreB, tournament, fields, arbitrator);
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
