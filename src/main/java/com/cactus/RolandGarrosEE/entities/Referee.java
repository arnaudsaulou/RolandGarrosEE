package com.cactus.RolandGarrosEE.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REFEREE")
public class Referee extends Member implements Serializable {
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy="referee")
    private List<SingleMatch> matchsSingle;
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy="referee")
    private List<DoubleMatch> matchsDouble;

    public Referee() {
    }

    public Referee(String firstname, String lastname, String nationality) {
        super(firstname, lastname, nationality);
        this.matchsSingle = new ArrayList<SingleMatch>();
        this.matchsDouble = new ArrayList<DoubleMatch>();
    }

    public List<SingleMatch> getMatchsSingle() {
        return matchsSingle;
    }

    public void setMatchsSingle(List<SingleMatch> matchsSingle) {
        this.matchsSingle = matchsSingle;
    }

    public List<DoubleMatch> getMatchsDouble() {
        return matchsDouble;
    }

    public void setMatchsDouble(List<DoubleMatch> matchsDouble) {
        this.matchsDouble = matchsDouble;
    }
}
