package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Referee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface RefereePersistentRemote {
    void saveArbitrator(Referee referee);
    void deleteArbitrator(Referee referee);
    Referee getArbitratorById(int referee);
    List<Referee> allArbitrator();
}
