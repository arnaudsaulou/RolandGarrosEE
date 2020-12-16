package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Player;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface PlayerPersistentRemote {
    void savePlayer(Player player);
    void deletePlayer(Player player);
    Player findPlayerById(int playerId);
    List<Player> allPlayer();
    List<Player> allPlayerByGender(Gender gender);
    List<Integer> allRankingsByGender(Gender gender);
    Player getPlayerWithLastnameAndFirstname(String lastname, String firstname);
}
