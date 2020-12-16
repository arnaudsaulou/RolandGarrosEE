package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidActorException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;
import com.cactus.RolandGarrosEE.utils.exceptions.UserNotFoundException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "detailsPlayerServlet", value = "/detailsJoueur")
public class DetailsPlayerServlet extends BaseServlet {

    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getPlayersList(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_DETAILS_PLAYER).forward(req, resp);
        } catch (UnauthenticatedUserException e){
            resp.sendRedirect(Constantes.URL_LOGIN);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.checkAuthentication(request);

            String id = this.getValue(request, Constantes.REQUEST_ATTR_ID);
            Player player = playerPersistentRemote.findPlayerById(Integer.parseInt(id));

            if (request.getParameter(Constantes.NEW_DETAILS_UPDATE) != null) {
                this.tryToUpdatePlayer(request, player);
            } else if (request.getParameter(Constantes.NEW_DETAILS_DELETE) != null) {
                this.tryToDeletePlayer(request, player);
            }

            response.sendRedirect(Constantes.URL_PLAYERS);
        } catch (UnauthenticatedUserException e) {
            response.sendRedirect(Constantes.URL_LOGIN);
        } catch (InvalidActorException e) {
            request.setAttribute("errorMessage", e.getMessage());
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_DETAILS_PLAYER).forward(request, response);
        }
    }

    private void tryToUpdatePlayer(HttpServletRequest req, Player player) throws InvalidActorException {
        player.setFirstname(this.getValue(req, "firstname"));
        player.setLastname(this.getValue(req, "lastname"));
        player.setNationality(this.getValue(req, "actorNationality"));
        player.setRankings(Integer.parseInt(this.getValue(req,"ranking")));

        playerPersistentRemote.updatePlayer(player);
    }

    private void tryToDeletePlayer(HttpServletRequest req, Player player) throws InvalidActorException {
        playerPersistentRemote.deletePlayer(player);
    }

    private void setupViewAttributes(HttpServletRequest req){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_PLAYERS);
        this.addToBreadcrumbs(Constantes.URL_DETAILS_PLAYER);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_PLAYERS);
        this.propagateAttributesToRequest(req);
    }

    private void getPlayersList(HttpServletRequest req) throws UserNotFoundException {
        String id = this.getValue(req, Constantes.REQUEST_ATTR_ID);

        if(id == null){
            throw new UserNotFoundException();
        }

        Player player = playerPersistentRemote.findPlayerById(Integer.parseInt(id));
        req.setAttribute(Constantes.NEW_DETAILS_FORM_PLAYER, player);
    }

}