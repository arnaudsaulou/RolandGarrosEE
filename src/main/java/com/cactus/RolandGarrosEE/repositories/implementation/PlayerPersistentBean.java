package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.entities.Referee;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
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
            entityManager.createQuery("delete from Player P WHERE P.id = :id")
                    .setParameter("id" , player.getId())
                    .executeUpdate();
        } catch (Exception ignored) {
            ignored.getMessage();
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

    @Override
    public void updatePlayer(Player player) {
        try {
            entityManager.createQuery("update Player P set P.lastname = :lastname, P.firstname = :firstname, P.nationality = :nationality, P.rankings = :rankings WHERE P.id = :id")
                    .setParameter("id" , player.getId())
                    .setParameter("lastname" , player.getLastname())
                    .setParameter("firstname" , player.getFirstname())
                    .setParameter("nationality" , player.getNationality())
                    .setParameter("rankings" , player.getRankings())
                    .executeUpdate();
        } catch (NoResultException ignored) {
            ignored.printStackTrace();
        }
    }
}
