package com.cactus.RolandGarrosEE.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DOUBLEMATCH")
public class DoubleMatch extends Match implements Serializable {
    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name="doublematch_team",
            joinColumns = @JoinColumn(name = "doublematch_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    @Size(min=2, max=2)
    private List<Team> teamsList;

    public DoubleMatch(@Size(min = 2, max = 2) List<Team> teamsList) {
        this.teamsList = teamsList;
    }

    public DoubleMatch(Date dateBegin, Date dateEnd, int scoreA, int scoreB, Tournament tournament, Court court, Referee referee, @Size(min = 2, max = 2) List<Team> teamsList) {
        super(dateBegin, dateEnd, scoreA, scoreB, tournament, court, referee);
        this.teamsList = teamsList;
    }

    public List<Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
    }
}
