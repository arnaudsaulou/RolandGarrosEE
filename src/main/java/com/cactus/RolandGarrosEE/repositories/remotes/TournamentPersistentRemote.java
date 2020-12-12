package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Tournament;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface TournamentPersistentRemote {
    void saveTournament(Tournament tournament);
    void deleteTournament(Tournament tournament);
    Tournament getTournamentById(int tournamentId);
    List<Tournament> allTournament();
}
