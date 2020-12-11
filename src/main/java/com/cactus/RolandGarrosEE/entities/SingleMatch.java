package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SINGLEMATCH")
public class SingleMatch extends Match{
    @ManyToOne(targetEntity=Player.class)
    private Player playerA;
    @ManyToOne(targetEntity=Player.class)
    private Player playerB;

    public SingleMatch() {
    }

    public SingleMatch(Date dateEnd, Date dateBegin, int scoreA, int scoreB, Tournament tournament, Fields fields, Arbitrator arbitrator) {

        super(dateEnd, dateBegin, scoreA, scoreB, tournament, fields, arbitrator);
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
