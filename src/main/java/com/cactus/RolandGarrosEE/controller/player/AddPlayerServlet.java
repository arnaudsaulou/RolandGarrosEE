package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.controller.Constantes;
import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidActorException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ajouterJoueurServlet", value = "/joueurs/ajouterJoueur")
public class AddPlayerServlet extends BaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_PLAYER).forward(req, resp);
        } catch (UnauthenticatedUserException e){
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.checkAuthentication(request);
            this.tryToSavePlayer(request);
            response.sendRedirect("../" + Constantes.URL_PLAYERS);
        } catch (UnauthenticatedUserException e) {
            response.sendRedirect("../" + Constantes.URL_LOGIN);
        } catch (InvalidActorException e) {
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_PLAYERS).forward(request, response);
        }
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_PLAYERS);
        this.addToBreadcrumbs(Constantes.TITLE_ADD_PLAYER);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_PLAYER);
        this.propagateAttributesToRequest(req);
    }

    private void tryToSavePlayer(HttpServletRequest req) throws InvalidActorException {
        String firstname = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_FIRSTNAME);
        String lastname = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_LASTNAME);
        String nationality = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_NATIONALITY);
        int rankings = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_RANKINGS);
        this.validateNewPlayer(firstname, lastname, nationality, rankings);
        Player newPlayer = new Player(firstname, lastname, nationality, rankings);
        playerPersistentRemote.savePlayer(newPlayer);
    }

    private void validateNewPlayer(String s, String firstname, String lastname, String nationality, int rankings) throws InvalidActorException {
        if (firstname == null || lastname == null || nationality == null || rankings == 0)
            throw new InvalidActorException();
    }

}
