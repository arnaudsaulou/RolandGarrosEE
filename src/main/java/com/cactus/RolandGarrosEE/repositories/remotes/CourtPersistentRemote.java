package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Court;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CourtPersistentRemote {
    void saveCourt(Court court);
    void deleteCourt(Court court);
    Court findCourtById(int fieldsId);
    List<Court> allCourts();
}
