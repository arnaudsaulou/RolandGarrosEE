package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Referee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface RefereePersistentRemote {
    void saveReferee(Referee referee);
    void updateReferee(Referee referee);
    void deleteReferee(Referee referee);
    Referee findRefereeById(int referee);
    List<Referee> allReferee();
    Referee getRefereeWithLastnameAndFirstname(String lastname, String firstname);
}
