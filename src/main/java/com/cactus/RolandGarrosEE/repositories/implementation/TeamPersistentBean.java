package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.entities.Team;
import com.cactus.RolandGarrosEE.repositories.remotes.TeamPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TeamPersistentBean implements TeamPersistentRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    @Override
    public void saveTeam(Team team) {
        try {
            entityManager.persist(team);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deleteTeam(Team team) {
        try {
            entityManager.remove(team);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Team getTeamById(int teamId) {
        Team team = null;
        try {
            team = entityManager.find(Team.class, teamId);
        } catch (NoResultException ignored) {
        }
        return team;
    }

    @Override
    public List<Team> allTeam() {
        List<Team> teams = null;
        try {
            teams = entityManager.createQuery("SELECT DISTINCT T FROM Team T join fetch T.playersList join fetch T.matchsDouble", Team.class)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return teams;
    }
}
