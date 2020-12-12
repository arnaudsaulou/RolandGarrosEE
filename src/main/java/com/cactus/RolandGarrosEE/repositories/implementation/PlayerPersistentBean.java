package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class PlayerPersistentBean implements PlayerPersistentRemote {

    @PersistenceContext(name = "PersistentUnitPU")
    EntityManager entityManager;

    public void savePlayer(Player player) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deletePlayer(Player player) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(player);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Player findPlayerById(int playerId) {
        Player player = null;
        try {
            entityManager.getTransaction().begin();
            player = entityManager.find(Player.class, playerId);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return player;
    }

    public List<Player> allPlayer() {
        List<Player> players = null;
        try {
            entityManager.getTransaction().begin();
            players = entityManager.createQuery("from Player ", Player.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return players;
    }
}
