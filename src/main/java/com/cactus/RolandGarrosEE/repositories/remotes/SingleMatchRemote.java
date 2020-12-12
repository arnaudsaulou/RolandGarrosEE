package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.SingleMatch;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface SingleMatchRemote {
   void saveSingleMatch(SingleMatch singleMatch);
   void deleteSingleMatch(SingleMatch singleMatch);
   Optional<SingleMatch> findSingleMatchById(long singleMatchId);
   List<SingleMatch> allSingleMatch();
}
