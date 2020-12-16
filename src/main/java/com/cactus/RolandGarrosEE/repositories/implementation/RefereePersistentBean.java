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
    public void saveReferee(Referee referee) {
        try {
            entityManager.persist(referee);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void updateReferee(Referee referee) {
        try {
            entityManager.createQuery("UPDATE Referee R SET R.firstname = :firstname, R.lastname = :lastname, R.nationality = :nationality WHERE P.id = :id")
                    .setParameter("id", referee.getId())
                    .setParameter("firstname", referee.getFirstname())
                    .setParameter("lastname", referee.getLastname())
                    .setParameter("nationality", referee.getNationality())
                    .executeUpdate();
        } catch (NoResultException ignored) {
        }
    }

    @Override
    public void deleteReferee(Referee referee) {
        try {
            entityManager.remove(referee);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Referee findRefereeById(int refereeId) {
        Referee referee = null;
        try {
            referee = entityManager.find(Referee.class, refereeId);
        } catch (NoResultException ignored) {
        }
        return referee;
    }

    @Override
    public List<Referee> allReferee() {
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
                    .setParameter("lastname", lastname).setParameter("firstname", firstname)
                    .getSingleResult();
        } catch (NoResultException ignored) {
        }
        return referee;
    }
}
