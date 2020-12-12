package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.SingleMatch;
import com.cactus.RolandGarrosEE.repositories.remotes.SingleMatchRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class SingleMatchPersistentBean implements SingleMatchRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveSingleMatch(SingleMatch singleMatch) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(singleMatch);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteSingleMatch(SingleMatch singleMatch) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(singleMatch);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public SingleMatch findSingleMatchById(int singleMatchId) {
        SingleMatch singleMatch = null;
        try {
            entityManager.getTransaction().begin();
            singleMatch = entityManager.find(SingleMatch.class, singleMatchId);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return singleMatch;
    }

    public List<SingleMatch> allSingleMatch() {
        List<SingleMatch> singleMatches = null;
        try {
            entityManager.getTransaction().begin();
            singleMatches = entityManager.createQuery("from SingleMatch", SingleMatch.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return singleMatches;
    }
}
