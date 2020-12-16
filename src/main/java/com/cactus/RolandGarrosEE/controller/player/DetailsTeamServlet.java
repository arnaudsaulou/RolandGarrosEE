package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.entities.Team;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.TeamPersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.enums.UserRole;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidActorException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;
import com.cactus.RolandGarrosEE.utils.exceptions.UserNotFoundException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "detailsTeamServlet", value = "/detailsEquipe")
public class DetailsTeamServlet extends BaseServlet {
    @EJB
    TeamPersistentRemote teamPersistentRemote;

    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            this.checkAuthentication(req, UserRole.ORGANIZER);
            this.setupViewAttributes(req);
            this.setTeamInView(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_DETAILS_TEAM).forward(req, resp);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect(Constantes.URL_LOGIN);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            this.checkAuthentication(req, UserRole.ORGANIZER);

            String id = this.getValue(req, Constantes.REQUEST_ATTR_ID);
            Team team = teamPersistentRemote.findTeamById(Integer.parseInt(id));

            if (req.getParameter(Constantes.NEW_DETAILS_UPDATE) != null) {
                int idPlayerA = Integer.parseInt(this.getValue(req, Constantes.NEW_TEAM_FORM_FIELD_PLAYER_A));
                int idPlayerB = Integer.parseInt(this.getValue(req, Constantes.NEW_TEAM_FORM_FIELD_PLAYER_B));
                this.tryToUpdateTeam(req, team, idPlayerA, idPlayerB);
            } else if (req.getParameter(Constantes.NEW_DETAILS_DELETE) != null)
                this.tryToDeleteTeam(req, team);

            resp.sendRedirect(Constantes.URL_TEAM);
        } catch (UnauthenticatedUserException e) {
            e.printStackTrace();
        } catch (InvalidActorException e) {
            req.setAttribute("errorMessage", e.getMessage());
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_DETAILS_REFEREE).forward(req, resp);
        }
    }

    private void tryToUpdateTeam(HttpServletRequest req, Team team, int idPlayerA, int idPlayerB)
            throws InvalidActorException {
        Player player1 = playerPersistentRemote.findPlayerById(idPlayerA);
        Player player2 = playerPersistentRemote.findPlayerById(idPlayerB);
        if (player1 == null || player2 == null)
            throw new InvalidActorException("Un joueur n'existe pas");
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        team.setPlayersList(players);
        teamPersistentRemote.updateTeam(team);
    }

    private void tryToDeleteTeam(HttpServletRequest req, Team team)
            throws InvalidActorException {
        teamPersistentRemote.deleteTeam(team);
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_TEAMS);
        this.addToBreadcrumbs(Constantes.TITLE_TEAMS_DETAILS);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_TEAMS_DETAILS);
        this.propagateAttributesToRequest(req);
    }

    private void setTeamInView(HttpServletRequest req)
            throws UserNotFoundException {
        String id = this.getValue(req, Constantes.REQUEST_ATTR_ID);

        if (id == null)
            throw new UserNotFoundException();

        Team team = teamPersistentRemote.findTeamById(Integer.parseInt(id));
        List<Player> players = playerPersistentRemote.allPlayerByGender(team.getGender());
        req.setAttribute(Constantes.REQUEST_ATTR_PLAYERS_LIST, players);
        req.setAttribute(Constantes.NEW_DETAILS_TEAM, team);
    }
}
