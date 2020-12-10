package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MATCH")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Match {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @NotNull
    @Column(name="ID")
    private int id;
    @NotNull
    @Column(name="TIME")
    private Date time;
    @NotNull
    @Column(name="DATE")
    private Date date;
    @NotNull
    @Column(name="SCOREA")
    private int scoreA;
    @NotNull
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

    public Match(Date time, Date date, int scoreA, int scoreB, Tournament tournament, Fields fields, Arbitrator arbitrator) {
        this.time = time;
        this.date = date;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.tournament = tournament;
        this.fields = fields;
        this.arbitrator = arbitrator;
    }
}
