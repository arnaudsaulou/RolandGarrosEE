package com.cactus.RolandGarrosEE.repositories.implementation;

import com.cactus.RolandGarrosEE.entities.Tournament;
import com.cactus.RolandGarrosEE.repositories.remotes.TournamentPersistentRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class TournamentPersistentBean implements TournamentPersistentRemote {
    @PersistenceContext(unitName = "PersistentUnitPU")
    EntityManager entityManager;

    public void saveTournament(Tournament tournament) {
    }

    public void deleteTournament(Tournament tournament) {
    }

    public Optional<Tournament> getTournamentById(int tournamentId) {
        return Optional.empty();
    }

    public List<Tournament> allTournament() {
        return null;
    }
}
