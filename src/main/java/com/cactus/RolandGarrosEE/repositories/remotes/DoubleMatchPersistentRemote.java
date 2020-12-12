package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.DoubleMatch;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DoubleMatchPersistentRemote {
    void addDoubleMatch(DoubleMatch doubleMatch);
    void deleteDoubleMatch(DoubleMatch doubleMatch);
    DoubleMatch findDoubleMatchById(int doubleMatchId);
    List<DoubleMatch> allDoubleMatch();
}
