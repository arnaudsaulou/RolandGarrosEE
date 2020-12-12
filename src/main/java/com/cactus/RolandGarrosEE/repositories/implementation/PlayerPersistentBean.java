package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Player;
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
    }

    public void deletePlayer(Player player) {
    }

    public Optional<Player> findPlayerById(int playerId) {
        return Optional.empty();
    }

    public List<Player> allPlayer() {
        return null;
    }
}
