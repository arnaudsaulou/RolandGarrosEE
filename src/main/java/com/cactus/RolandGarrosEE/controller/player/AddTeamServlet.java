package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.TeamPersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.enums.UserRole;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "addEquipeServlet", value = "/equipes/ajouterEquipe")
public class AddTeamServlet extends BaseServlet {

    @EJB
    TeamPersistentRemote teamPersistentRemote;
    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req, UserRole.ORGANIZER);
            this.setupViewAttributes(req);
            this.getPlayersList(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_TEAM).forward(req, resp);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGOUT);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            this.checkAuthentication(req, UserRole.ORGANIZER);
            this.tryToTeamMatch(req);
            resp.sendRedirect("../" + Constantes.URL_TEAM);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGOUT);
        }
    }

    private void tryToTeamMatch(HttpServletRequest req) {
        String nameTeam = this.getValue(req, Constantes.NEW_TEAM_FORM_FIELD_NAME);
        String idFirstPlayer = req.getParameter(Constantes.NEW_TEAM_FORM_FIELD_PLAYER_A);
        String idSecondPlayer = req.getParameter(Constantes.NEW_TEAM_FORM_FIELD_PLAYER_B);

        Player playerA = playerPersistentRemote.findPlayerById(Integer.parseInt(idFirstPlayer));
        Player playerB = playerPersistentRemote.findPlayerById(Integer.parseInt(idSecondPlayer));

        List<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);

        Gender gender;
        if(players.get(0).getGender() == Gender.HOMME){
            if(players.get(1).getGender() == Gender.HOMME){
                gender = Gender.HOMME;
            } else {
                gender = Gender.MIXTE;
            }
        } else {
            if(players.get(1).getGender() == Gender.FEMME){
                gender = Gender.FEMME;
            } else {
                gender = Gender.MIXTE;
            }
        }

        Team team = new Team(0, nameTeam, gender, players);

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
