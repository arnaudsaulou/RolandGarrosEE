package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Arbitrator;
import com.cactus.RolandGarrosEE.repositories.remotes.ArbitratorPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class ArbitratorPersistentBean implements ArbitratorPersistentRemote {
    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveArbitrator(Arbitrator arbitrator) {
    }

    public void deleteArbitrator(Arbitrator arbitrator) {
    }

    public Optional<Arbitrator> getArbitratorById(int arbitratorId) {
        return Optional.empty();
    }

    public List<Arbitrator> allArbitrator() {
        return null;
    }
}
