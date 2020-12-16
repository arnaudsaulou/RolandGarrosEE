package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.Player;
import com.cactus.RolandGarrosEE.repositories.remotes.PlayerPersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidActorException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ajouterJoueurServlet", value = "/joueurs/ajouterJoueur")
public class AddPlayerServlet extends BaseServlet {

    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_PLAYER).forward(req, resp);
        } catch (UnauthenticatedUserException e) {
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
            request.setAttribute("errorMessage", e.getMessage());
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_PLAYER).forward(request, response);
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
        int rankings = Integer.parseInt(this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_RANKINGS));
        Gender gender = Gender.getGenderFromString(this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_GENDER));
        this.validateNewPlayer(firstname, lastname, nationality, rankings, gender);
        Player newPlayer = new Player(firstname, lastname, nationality, rankings, gender);
        playerPersistentRemote.savePlayer(newPlayer);
    }

    private void validateNewPlayer(String firstname, String lastname, String nationality, int rankings, Gender gender) throws InvalidActorException {
        if (firstname == null || lastname == null || nationality == null || gender == null)
            throw new InvalidActorException();
        if (playerPersistentRemote.allRankingsByGender(gender).contains(rankings)) {
            throw new InvalidActorException("Ce classement est déjà attribué à un autre joueur");
        }
        if (playerPersistentRemote.getPlayerWithLastnameAndFirstname(lastname, firstname) !=  null){
            throw new InvalidActorException("Ce joueur a déjà été ajouté");
        }

    }


}
