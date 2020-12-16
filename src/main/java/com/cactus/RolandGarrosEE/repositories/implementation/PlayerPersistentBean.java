package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlayerPersistentBean implements PlayerPersistentRemote {
    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    @Override
    public void savePlayer(Player player) {
        try {
            entityManager.persist(player);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void deletePlayer(Player player) {
        try {
            entityManager.remove(player);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Player findPlayerById(int playerId) {
        Player player = null;
        try {
            player = entityManager.find(Player.class, playerId);
        } catch (NoResultException ignored) {
        }
        return player;
    }

    @Override
    public List<Player> allPlayer() {
        List<Player> players = null;
        try {
            players = entityManager.createQuery("SELECT DISTINCT P FROM Player P", Player.class)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return players;
    }

    @Override
    public List<Player> allPlayerByGender(Gender gender) {
        List<Player> players = null;
        try {
            players = entityManager.createQuery("SELECT DISTINCT P FROM Player P WHERE P.gender = :gender", Player.class)
                    .setParameter("gender", gender)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return players;
    }

    public List<Integer> allRankingsByGender(Gender gender){
        List<Integer> rankings = null;
        try {
            rankings = entityManager.createQuery("SELECT DISTINCT P.rankings FROM Player P WHERE P.gender = :gender", Integer.class)
                    .setParameter("gender", gender)
                    .getResultList();
        } catch (NoResultException ignored) {
        }
        return rankings;
    }

    public Player getPlayerWithLastnameAndFirstname(String lastname, String firstname) {
        Player player = null;
        try {
            player = entityManager.createQuery("SELECT DISTINCT P FROM Player P WHERE P.lastname = :lastname AND P.firstname= :firstname", Player.class)
                    .setParameter("lastname",lastname).setParameter("firstname", firstname)
                    .getSingleResult();
        } catch (NoResultException ignored) {
        }
        return player;
    }
}
