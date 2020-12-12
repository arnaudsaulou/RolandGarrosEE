package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
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
    @Nullable
    @Column(name="DATEEND")
    private Date dateEnd;
    @Nullable
    @Column(name="SCOREA")
    private int scoreA;
    @Nullable
    @Column(name="SCOREB")
    private int scoreB;
    @ManyToOne
    private Tournament tournament;
    @ManyToOne
    private Fields fields;
    @ManyToOne
    private Arbitrator arbitrator;

    public Match() {
    }

    public Match(Date dateBegin, Date dateEnd, int scoreA, int scoreB, Tournament tournament, Fields fields, Arbitrator arbitrator) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.tournament = tournament;
        this.fields = fields;
        this.arbitrator = arbitrator;
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

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public Arbitrator getArbitrator() {
        return arbitrator;
    }

    public void setArbitrator(Arbitrator arbitrator) {
        this.arbitrator = arbitrator;
    }
}
