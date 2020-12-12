package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Team;
import com.cactus.RolandGarrosEE.repositories.remotes.TeamPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class TeamPersistentBean implements TeamPersistentRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveTeam(Team team) {
    }

    public void deleteTeam(Team team) {
    }

    public Optional<Team> getTeamById(long teamId) {
        return Optional.empty();
    }

    public List<Team> allTeam() {
        return null;
    }
}
