package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Team;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface TeamPersistentRemote {
    void saveTeam(Team team);
    void deleteTeam(Team team);
    Team getTeamById(int teamId);
    List<Team> allTeam();
}
