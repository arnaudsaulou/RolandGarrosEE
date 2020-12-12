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
    }

    public void deleteSingleMatch(SingleMatch singleMatch) {
    }

    public Optional<SingleMatch> findSingleMatchById(long singleMatchId) {
        return Optional.empty();
    }

    public List<SingleMatch> allSingleMatch() {
        return null;
    }
}
