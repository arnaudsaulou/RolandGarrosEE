package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ARBITRATOR")
public class Arbitrator extends Member {
    @OneToMany
    private List<Match> matchs;

    public Arbitrator() {
    }

    public Arbitrator(String firstname, String lastname, String nationality) {
        super(firstname, lastname, nationality);
        this.matchs = new ArrayList<Match>();
    }
}
