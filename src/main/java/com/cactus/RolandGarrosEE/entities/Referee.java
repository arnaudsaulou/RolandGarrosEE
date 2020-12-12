package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REFEREE")
public class Referee extends Member implements Serializable {
    @ManyToMany
    private List<SingleMatch> matchsSingle;
    @ManyToMany
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
