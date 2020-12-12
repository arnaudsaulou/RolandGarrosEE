package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.SingleMatch;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SingleMatchRemote {
   void saveSingleMatch(SingleMatch singleMatch);
   void deleteSingleMatch(SingleMatch singleMatch);
   SingleMatch findSingleMatchById(int singleMatchId);
   List<SingleMatch> allSingleMatch();
}
