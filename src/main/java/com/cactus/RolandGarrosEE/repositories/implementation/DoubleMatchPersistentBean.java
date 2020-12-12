package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.DoubleMatch;
import com.cactus.RolandGarrosEE.repositories.remotes.DoubleMatchPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DoubleMatchPersistentBean implements DoubleMatchPersistentRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    public void addDoubleMatch(DoubleMatch doubleMatch) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(doubleMatch);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteDoubleMatch(DoubleMatch doubleMatch) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(doubleMatch);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public DoubleMatch findDoubleMatchById(int doubleMatchId) {
        DoubleMatch match = null;
        try {
            entityManager.getTransaction().begin();
            match = entityManager.find(DoubleMatch.class, doubleMatchId);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return match;
    }

    public List<DoubleMatch> allDoubleMatch() {
        List<DoubleMatch> doubleMatches = null;
        try {
            entityManager.getTransaction().begin();
            doubleMatches = entityManager.createQuery("from DoubleMatch", DoubleMatch.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return doubleMatches;
    }
}
