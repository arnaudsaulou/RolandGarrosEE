package com.cactus.RolandGarrosEE.controller.staff;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.entities.Referee;
import com.cactus.RolandGarrosEE.repositories.remotes.RefereePersistentRemote;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidActorException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ajouterArbitreServlet", value = "/arbitres/ajouterArbitre")
public class AddRefereeServlet extends BaseServlet {

    @EJB
    RefereePersistentRemote refereePersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_REFEREE).forward(req, resp);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            this.checkAuthentication(req);
            this.tryToSaveReferee(req);
            resp.sendRedirect("../" + Constantes.URL_REFEREES);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        } catch (InvalidActorException e) {
            req.setAttribute("errorMessage", e.getMessage());
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_REFEREE).forward(req, resp);
        }
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_REFEREES);
        this.addToBreadcrumbs(Constantes.TITLE_ADD_REFEREE);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_REFEREE);
        this.propagateAttributesToRequest(req);
    }

    private void tryToSaveReferee(HttpServletRequest req) throws InvalidActorException {
        String firstname = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_FIRSTNAME);
        String lastname = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_LASTNAME);
        String nationality = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_NATIONALITY);
        this.validateNewReferee(firstname, lastname, nationality);
        Referee newReferee = new Referee(firstname, lastname, nationality);
        refereePersistentRemote.saveArbitrator(newReferee);
    }

    private void validateNewReferee(String firstname, String lastname, String nationality) throws InvalidActorException {
        if (firstname == null || lastname == null || nationality == null)
            throw new InvalidActorException();
        if (refereePersistentRemote.getRefereeWithLastnameAndFirstname(lastname, firstname) !=  null)
            throw new InvalidActorException("Cet arbitre a déjà été ajouté");
    }

}
