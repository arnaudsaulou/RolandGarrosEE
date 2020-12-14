package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.TeamPersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "addEquipeServlet", value = "/equipes/ajouterEquipe")
public class AddTeamServlet extends BaseServlet {

    @EJB
    TeamPersistentRemote teamPersistentRemote;
    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getPlayersList(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_TEAM).forward(req, resp);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            this.checkAuthentication(req);
            this.tryToTeamMatch(req);
            resp.sendRedirect("../" + Constantes.URL_TEAM);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    private void tryToTeamMatch(HttpServletRequest req) {
        String nameTeam = this.getValue(req, Constantes.NEW_TEAM_FORM_FIELD_NAME);
        String idFirstPlayer = req.getParameter(Constantes.NEW_TEAM_FORM_FIELD_PLAYER_A);
        String idSecondPlayer = req.getParameter(Constantes.NEW_TEAM_FORM_FIELD_PLAYER_B);

        Player playerA = playerPersistentRemote.findPlayerById(Integer.parseInt(idFirstPlayer));
        Player playerB = playerPersistentRemote.findPlayerById(Integer.parseInt(idSecondPlayer));

        Set<Player> players = new HashSet<>();
        players.add(playerA);
        players.add(playerB);

        Team team = new Team(0, nameTeam, players, new HashSet<>());

        teamPersistentRemote.saveTeam(team);
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_TEAMS);
        this.addToBreadcrumbs(Constantes.TITLE_ADD_TEAM);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_TEAM);
        this.propagateAttributesToRequest(req);
    }

    private void getPlayersList(HttpServletRequest request){
        List<Player> playersList = playerPersistentRemote.allPlayer();
        request.setAttribute(Constantes.REQUEST_ATTR_PLAYERS_LIST, playersList);
    }
}
