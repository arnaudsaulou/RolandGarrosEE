package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Tournament;
import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.remotes.TournamentPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class TournamentPersistentBean implements TournamentPersistentRemote {

    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveTournament(Tournament tournament) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tournament);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteTournament(Tournament tournament) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(tournament);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Tournament getTournamentById(int tournamentId) {
        Tournament tournament = null;
        try {
            entityManager.getTransaction().begin();
            tournament = entityManager.find(Tournament.class, tournamentId);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return tournament;
    }

    public List<Tournament> allTournament() {
        List<Tournament> tournaments = null;
        try {
            entityManager.getTransaction().begin();
            tournaments = entityManager.createQuery("from Tournament ", Tournament.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return tournaments;
    }
}
