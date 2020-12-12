package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Team;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface TeamPersistentRemote {
    void saveTeam(Team team);
    void deleteTeam(Team team);
    Optional<Team> getTeamById(int teamId);
    List<Team> allTeam();
}
