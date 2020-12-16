package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.Team;
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
import java.util.List;

@WebServlet(name = "equipeServlet", value = "/equipes")
public class TeamServlet extends BaseServlet {

    @EJB
    TeamPersistentRemote teamPeristentRemote;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            this.checkAuthentication(request, UserRole.ORGANIZER);
            this.setupViewAttributes(request);
            this.getTeamsList(request);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_TEAMS).forward(request, response);
        } catch (UnauthenticatedUserException e){
            response.sendRedirect(Constantes.URL_LOGOUT);
        }
    }

    private void setupViewAttributes(HttpServletRequest req){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_TEAMS);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_TEAMS);
        this.propagateAttributesToRequest(req);
    }

    private void getTeamsList(HttpServletRequest request){
        List<Team> teamsList = teamPeristentRemote.allTeam();
        request.setAttribute(Constantes.REQUEST_ATTR_TEAMS_LIST, teamsList);
    }
}
