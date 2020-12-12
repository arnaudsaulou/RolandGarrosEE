package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ARBITRATOR")
public class Arbitrator extends Member {
    @ManyToMany
    private List<SingleMatch> matchsSingle;
    @ManyToMany
    private List<DoubleMatch> matchsDouble;

    public Arbitrator() {
    }

    public Arbitrator(String firstname, String lastname, String nationality) {
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
