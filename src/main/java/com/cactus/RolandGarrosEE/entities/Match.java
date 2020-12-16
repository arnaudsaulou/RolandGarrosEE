package com.cactus.RolandGarrosEE.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class Match implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name="ID")
    protected int id;
    @NotNull
    @Column(name="DATEBEGIN")
    private Date dateBegin;
    @Column(name="DATEEND")
    private Date dateEnd;
    @Column(name="SCOREA")
    private Integer scoreA;
    @Column(name="SCOREB")
    private Integer scoreB;
    @ManyToOne
    private Tournament tournament;
    @ManyToOne
    private Court court;
    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Referee referee;

    public Match() {
    }

    public Match(Date dateBegin, Date dateEnd, int scoreA, int scoreB, Tournament tournament, Court court, Referee referee) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.tournament = tournament;
        this.court = court;
        this.referee = referee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
