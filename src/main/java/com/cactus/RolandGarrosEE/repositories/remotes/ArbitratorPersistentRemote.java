package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Arbitrator;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface ArbitratorPersistentRemote {
    void saveArbitrator(Arbitrator arbitrator);
    void deleteArbitrator(Arbitrator arbitrator);
    Optional<Arbitrator> getArbitratorById(int arbitratorId);
    List<Arbitrator>  allArbitrator();
}
