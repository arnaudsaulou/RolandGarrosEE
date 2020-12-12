package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Referee;
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

    public void saveArbitrator(Referee referee) {
        entityManager.persist(referee);
    }

    public void deleteArbitrator(Referee referee) {
        entityManager.remove(referee);
    }

    public Optional<Referee> getArbitratorById(int arbitratorId) {
        return Optional.empty();
    }

    public List<Referee> allArbitrator() {
        return entityManager.createQuery("SELECT arbitrators FROM Referee arbitrators", Referee.class).getResultList();
    }
}
