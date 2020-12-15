package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.SingleMatch;
import com.cactus.RolandGarrosEE.repositories.remotes.SingleMatchRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class SingleMatchPersistentBean implements SingleMatchRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    @Override
    public void updateScore(int id, String scoreA, String scoreB, Date dateEnd) {
        try {
            entityManager.createQuery("update SingleMatch sm set sm.scoreA = :scoreA, sm.scoreB = :scoreB, dateEnd = :dateEnd WHERE sm.id = :id")
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
    public void saveSingleMatch(SingleMatch singleMatch) {
        try {
            entityManager.persist(singleMatch);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    @Override
    public void deleteSingleMatch(SingleMatch singleMatch) {
        try {
            entityManager.remove(singleMatch);
        } catch (Exception ignored) {
        }
    }

    @Override
    public SingleMatch findSingleMatchById(int singleMatchId) {
        SingleMatch singleMatch = null;
        try {
            singleMatch = entityManager.find(SingleMatch.class, singleMatchId);
        } catch (NoResultException ignored) {
        }
        return singleMatch;
    }

    @Override
    public List<SingleMatch> allSingleMatch() {
        List<SingleMatch> singleMatches = null;
        try {
            singleMatches = entityManager.createQuery("from SingleMatch", SingleMatch.class).getResultList();
        } catch (NoResultException ignored) {
        }
        return singleMatches;
    }

    @Override
    public List<SingleMatch> allSingleMatchByTournamentId(int tournamentId) {
        List<SingleMatch> singleMatches = null;
        try {
            singleMatches = entityManager.createQuery("from SingleMatch sm WHERE sm.tournament.id = :tournamentId", SingleMatch.class)
                    .setParameter("tournamentId" , tournamentId)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return singleMatches;
    }
}
