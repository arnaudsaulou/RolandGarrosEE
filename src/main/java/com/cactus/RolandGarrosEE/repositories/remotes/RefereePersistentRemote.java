package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Referee;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface RefereePersistentRemote {
    void saveArbitrator(Referee referee);

    void deleteArbitrator(Referee referee);

    Optional<Referee> getArbitratorById(int arbitratorId);

    List<Referee> allArbitrator();
}
