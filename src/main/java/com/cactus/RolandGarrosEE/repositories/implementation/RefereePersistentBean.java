package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Arbitrator;
import com.cactus.RolandGarrosEE.repositories.remotes.RefereePersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class RefereePersistentBean implements RefereePersistentRemote {

    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveArbitrator(Arbitrator arbitrator) {
        entityManager.persist(arbitrator);
    }

    public void deleteArbitrator(Arbitrator arbitrator) {
        entityManager.remove(arbitrator);
    }

    public Optional<Arbitrator> getArbitratorById(long arbitratorId) {
        return Optional.empty();
    }

    public List<Arbitrator> allArbitrator() {
        return entityManager.createQuery("SELECT arbitrators FROM Arbitrator arbitrators", Arbitrator.class).getResultList();
    }
}
