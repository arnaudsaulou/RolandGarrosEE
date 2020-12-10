package com.cactus.RolandGarrosEE.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DOUBLEMATCH")
public class DoubleMatch extends Match {
    @ManyToOne
    private Team teamA;
    @ManyToOne
    private Team teamB;

    public DoubleMatch() {
    }

    public DoubleMatch(Date time, Date date, int scoreA, int scoreB, Tournament tournament, Fields fields, Arbitrator arbitrator) {
        super(time, date, scoreA, scoreB, tournament, fields, arbitrator);
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }
}
