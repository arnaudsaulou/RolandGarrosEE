package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.controller.Constantes;
import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "joueurServlet", value = "/joueurs")
public class PlayerServlet extends BaseServlet {

    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getPlayersList(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_PLAYERS).forward(req, resp);
        } catch (UnauthenticatedUserException e){
            resp.sendRedirect(Constantes.URL_LOGIN);
        }
    }

    private void setupViewAttributes(HttpServletRequest req){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_PLAYERS);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_PLAYERS);
        this.propagateAttributesToRequest(req);
    }

    private void getPlayersList(HttpServletRequest req){
        List<Player> playersList = playerPersistentRemote.allPlayer();
        req.setAttribute(Constantes.REQUEST_ATTR_PLAYERS_LIST,playersList);
    }

}