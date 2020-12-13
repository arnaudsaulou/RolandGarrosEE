package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.FieldsPersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.RefereePersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.SingleMatchRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.TournamentPersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidActorException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ajouterMatch", value = "/tournoi/ajouterMatch")
public class AddMatchServlet extends BaseServlet {

    @EJB
    SingleMatchRemote singleMatchRemote;
    TournamentPersistentRemote tournamentPersistentRemote;
    RefereePersistentRemote refereePersistentRemote;
    FieldsPersistentRemote fieldsPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);

            // TODO Remove hardcore code double => Replace with enum (discuss which one)
            if (req.getParameter(Constantes.URL_PARAM_MATCH_TYPE).equals("double")) {


                this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_DOUBLE_MATCH).forward(req, resp);
            } else {
                req.setAttribute(Constantes.URL_PARAM_GENDER, req.getParameter(Constantes.URL_PARAM_GENDER));
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_SINGLE_MATCH).forward(req, resp);
            }
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            this.checkAuthentication(req);
            this.tryToSaveMatch(req);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();

        //TODO Choose breadcrumbs to display
        /*this.addToBreadcrumbs();
        this.addToBreadcrumbs();*/
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_MATCH);
        this.propagateAttributesToRequest(req);
    }

    private void tryToSaveMatch(HttpServletRequest req) {
        String startDate = this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_START_DATE);
        String partA = this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_PART_A);
        String partB = this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_PART_B);

        Tournament tournament = this.getTournament(req);
        Referee referee = this.getReferee(req);
        Fields fields = this.getFields(req);
        //Date dateStart = new Date(startDate);

        //this.validateNewMatch(startDate, partA, partB, referee, court);

        SingleMatch newSingleMatch = new SingleMatch(null, null, 0, 0, tournament, fields, referee);
        singleMatchRemote.saveSingleMatch(newSingleMatch);
    }

    private Fields getFields(HttpServletRequest req) {
        int fieldId = Integer.parseInt(this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_COURT));
        Fields fields = fieldsPersistentRemote.findFieldsById(fieldId);
        return fields;
    }

    private Referee getReferee(HttpServletRequest req) {
        int refereeId = Integer.parseInt(this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_REFEREE));
        Referee referee = refereePersistentRemote.getArbitratorById(refereeId);
        return referee;
    }

    private Tournament getTournament(HttpServletRequest req) {
        TypeTournament type = TypeTournament.valueOf(this.getValue(req, Constantes.URL_PARAM_MATCH_TYPE));
        Gender gender = Gender.valueOf(this.getValue(req, Constantes.URL_PARAM_GENDER));
        Tournament tournament = tournamentPersistentRemote.getTournamentByTypeAndGender(type, gender);
        return tournament;
    }

    /*private void validateNewMatch(String startDate, String partA, String partB, String referee, String court) throws InvalidActorException {
        if (startDate == null || partA == null || partB == null || referee == null || court == null)
            throw new InvalidActorException();
    }*/

}
