package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DOUBLEMATCH")
public class DoubleMatch extends Match implements Serializable {
    @ManyToOne(targetEntity=Team.class)
    private Team teamA;
    @ManyToOne(targetEntity=Team.class)
    private Team teamB;

    public DoubleMatch() {
    }

    public DoubleMatch(Date dateEnd, Date dateBegin, int scoreA, int scoreB, Tournament tournament, Fields fields, Referee referee) {
        super(dateEnd, dateBegin, scoreA, scoreB, tournament, fields, referee);
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
