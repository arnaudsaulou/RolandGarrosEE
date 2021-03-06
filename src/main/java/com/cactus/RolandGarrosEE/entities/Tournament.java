package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TOURNAMENT")
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name="ID")
    private int id;
    @NotNull
    @Column(name="TYPE")
    @Enumerated(EnumType.STRING)
    private TypeTournament typeTournament;
    @NotNull
    @Column(name="GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    @Column(name="DATEBEGIN")
    @Temporal(TemporalType.DATE)
    private Date dateBegin;
    @NotNull
    @Column(name="DATEEND")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @NotNull
    @Column(name="NBMATCH")
    private int nbMatch;

    public Tournament(TypeTournament typeTournament, Gender gender, Date dateBegin, Date dateEnd, int nbMatch) {
        this.typeTournament = typeTournament;
        this.gender = gender;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.nbMatch = nbMatch;
    }

    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeTournament getTypeTournament() {
        return typeTournament;
    }

    public void setTypeTournament(TypeTournament typeTournament) {
        this.typeTournament = typeTournament;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public int getNbMatch() {
        return nbMatch;
    }

    public void setNbMatch(int nbMatch) {
        this.nbMatch = nbMatch;
    }
}
