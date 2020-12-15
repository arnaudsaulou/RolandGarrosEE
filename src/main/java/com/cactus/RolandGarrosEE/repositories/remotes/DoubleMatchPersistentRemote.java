package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.DoubleMatch;
import com.cactus.RolandGarrosEE.entities.SingleMatch;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

@Remote
public interface DoubleMatchPersistentRemote {
    void updateScore(int id, String scoreA, String B, Date dateEnd);
    void saveDoubleMatch(DoubleMatch doubleMatch);
    void addDoubleMatch(DoubleMatch doubleMatch);
    void deleteDoubleMatch(DoubleMatch doubleMatch);
    DoubleMatch findDoubleMatchById(int doubleMatchId);
    List<DoubleMatch> allDoubleMatch();
    List<DoubleMatch> allDoubleMatchByTournamentId(int tournamentId);
}
