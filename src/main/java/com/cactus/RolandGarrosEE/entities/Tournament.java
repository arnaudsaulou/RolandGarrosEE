package com.cactus.RolandGarrosEE.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TOURNAMENT")
public class Tournament {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name="ID")
    private int id;
    @NotNull
    @Column(name="ISDOUBLE")
    private boolean isDouble;
    @NotNull
    @Column(name="TYPE")
    @Enumerated(EnumType.STRING)
    private TypeTournament typeTournament;
    @OneToMany
    private List<Match> matchs;
}
