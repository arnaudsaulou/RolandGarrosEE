package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Player;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface PlayerPersistentRemote {
    void savePlayer(Player player);
    void deletePlayer(Player player);
    Optional<Player> findPlayerById(int playerId);
    List<Player> allPlayer();
}
