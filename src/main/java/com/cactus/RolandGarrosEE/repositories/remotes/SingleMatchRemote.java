package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.SingleMatch;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SingleMatchRemote {
   void updateScore(int id, String scoreA, String B);
   void saveSingleMatch(SingleMatch singleMatch);
   void deleteSingleMatch(SingleMatch singleMatch);
   SingleMatch findSingleMatchById(int singleMatchId);
   List<SingleMatch> allSingleMatch();
   List<SingleMatch> allSingleMatchByTournamentId(int tournamentId);
}
