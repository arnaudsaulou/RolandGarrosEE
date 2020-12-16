package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Team;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface TeamPersistentRemote {
    void saveTeam(Team team);
    void deleteTeam(Team team);
    void updateTeam(Team team);
    Team findTeamById(int teamId);
    List<Team> allTeam();
    List<Team> allTeamByGender(Gender gender);
}
