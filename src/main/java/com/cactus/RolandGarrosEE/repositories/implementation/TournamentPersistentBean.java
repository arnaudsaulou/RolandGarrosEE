package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Tournament;
import com.cactus.RolandGarrosEE.entities.TypeTournament;
import com.cactus.RolandGarrosEE.repositories.remotes.TournamentPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TournamentPersistentBean implements TournamentPersistentRemote {

    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    @Override
    public void saveTournament(Tournament tournament) {
        try {
            entityManager.persist(tournament);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deleteTournament(Tournament tournament) {
        try {
            entityManager.remove(tournament);
        } catch (Exception ignored) { }
    }

    public Tournament getTournamentById(int tournamentId) {
        Tournament tournament = null;
        try {
            tournament = entityManager.find(Tournament.class, tournamentId);
        } catch (NoResultException ignored) {
        }
        return tournament;
    }

    public Tournament getTournamentByTypeAndGender(TypeTournament typeTournamentEnum, Gender genderEnum) {
        Tournament tournament = null;
        try {
            tournament = entityManager.createQuery(
                    "from Tournament t where t.gender = :gender and t.typeTournament = :type"
                    , Tournament.class)
                    .setParameter("gender", genderEnum)
                    .setParameter("type", typeTournamentEnum)
                    .getSingleResult();
        } catch (NoResultException ignored) {
        }
        return tournament;
    }

    public List<Tournament> allTournament() {
        List<Tournament> tournaments = null;
        try {
            tournaments = entityManager.createQuery("from Tournament ", Tournament.class).getResultList();
        } catch (NoResultException ignored) {
        }
        return tournaments;
    }
}
