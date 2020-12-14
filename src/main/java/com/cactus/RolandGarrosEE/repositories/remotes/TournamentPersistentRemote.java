package com.cactus.RolandGarrosEE.repositories.remotes;

import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Tournament;
import com.cactus.RolandGarrosEE.entities.TypeTournament;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface TournamentPersistentRemote {
    void saveTournament(Tournament tournament);
    void deleteTournament(Tournament tournament);
    Tournament getTournamentById(int tournamentId);
    Tournament getTournamentByTypeAndGender(TypeTournament typeTournament, Gender gender);
    List<Tournament> allTournament();
}
