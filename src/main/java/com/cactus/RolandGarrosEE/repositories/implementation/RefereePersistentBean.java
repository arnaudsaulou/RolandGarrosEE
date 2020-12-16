package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.entities.Referee;
import com.cactus.RolandGarrosEE.repositories.remotes.RefereePersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RefereePersistentBean implements RefereePersistentRemote {
    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    @Override
    public void saveArbitrator(Referee referee) {
        try {
            entityManager.persist(referee);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deleteArbitrator(Referee referee) {
        try {
            entityManager.remove(referee);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Referee getArbitratorById(int refereeId) {
        Referee referee = null;
        try {
            referee = entityManager.find(Referee.class, refereeId);
        } catch (NoResultException ignored) {
        }
        return referee;
    }

    @Override
    public List<Referee> allArbitrator() {
        List<Referee> referees = null;
        try {
            referees = entityManager.createQuery("SELECT arbitrators FROM Referee arbitrators", Referee.class).getResultList();
        } catch (NoResultException ignored) {
        }
        return referees;
    }

    public Referee getRefereeWithLastnameAndFirstname(String lastname, String firstname) {
        Referee referee = null;
        try {
            referee = entityManager.createQuery("SELECT DISTINCT R FROM Referee R WHERE R.lastname = :lastname AND R.firstname = :firstname", Referee.class)
                    .setParameter("lastname",lastname).setParameter("firstname", firstname)
                    .getSingleResult();
        } catch (NoResultException ignored) {
        }
        return referee;
    }
}
