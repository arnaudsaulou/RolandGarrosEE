package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.DoubleMatch;
import com.cactus.RolandGarrosEE.entities.SingleMatch;
import com.cactus.RolandGarrosEE.repositories.remotes.DoubleMatchPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class DoubleMatchPersistentBean implements DoubleMatchPersistentRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    @Override
    public void updateScore(int id, String scoreA, String scoreB, Date dateEnd) {
        try {
            entityManager.createQuery("update DoubleMatch sm set scoreA = :scoreA, scoreB = :scoreB, dateEnd = :dateEnd WHERE sm.tournament.id = :id", DoubleMatch.class)
                    .setParameter("id" , id)
                    .setParameter("scoreA" , Integer.parseInt(scoreA))
                    .setParameter("scoreB" , Integer.parseInt(scoreB))
                    .setParameter("dateEnd" , dateEnd)
                    .executeUpdate();
        } catch (NoResultException ignored) {
            ignored.printStackTrace();
        }
    }

    @Override
    public void saveDoubleMatch(DoubleMatch doubleMatch) {
        try {
            entityManager.persist(doubleMatch);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    @Override
    public void addDoubleMatch(DoubleMatch doubleMatch) {
        try {
            entityManager.persist(doubleMatch);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deleteDoubleMatch(DoubleMatch doubleMatch) {
        try {
            entityManager.remove(doubleMatch);
        } catch (Exception ignored) {
        }
    }

    @Override
    public DoubleMatch findDoubleMatchById(int doubleMatchId) {
        DoubleMatch match = null;
        try {
            match = entityManager.find(DoubleMatch.class, doubleMatchId);
        } catch (NoResultException ignored) {
        }
        return match;
    }

    @Override
    public List<DoubleMatch> allDoubleMatch() {
        List<DoubleMatch> doubleMatches = null;
        try {
            doubleMatches = entityManager.createQuery("from DoubleMatch", DoubleMatch.class).getResultList();
        } catch (NoResultException ignored) {
        }
        return doubleMatches;
    }

    @Override
    public List<DoubleMatch> allDoubleMatchByTournamentId(int tournamentId) {
        List<DoubleMatch> doubleMatches = null;
        try {
            doubleMatches = entityManager.createQuery("from DoubleMatch dm WHERE dm.tournament.id = :tournamentId", DoubleMatch.class)
                    .setParameter("tournamentId" , tournamentId)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return doubleMatches;
    }
}
