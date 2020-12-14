package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.*;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidMatchException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ajouterMatch", value = "/tournoi/ajouterMatch")
public class AddMatchServlet extends BaseServlet {

    @EJB
    SingleMatchRemote singleMatchRemote;

    @EJB
    TournamentPersistentRemote tournamentPersistentRemote;

    @EJB
    RefereePersistentRemote refereePersistentRemote;

    @EJB
    CourtPersistentRemote courtPersistentRemote;

    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);


            // TODO Remove hardcore code double => Replace with enum (discuss which one)
            if (req.getParameter(Constantes.URL_PARAM_MATCH_TYPE).equals("double")) {
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_DOUBLE_MATCH).forward(req, resp);
            } else {
                req.setAttribute(Constantes.URL_PARAM_GENDER, req.getParameter(Constantes.URL_PARAM_GENDER));
                req.setAttribute(Constantes.URL_PARAM_MATCH_TYPE, req.getParameter(Constantes.URL_PARAM_MATCH_TYPE));

                List<Player> players = playerPersistentRemote.allPlayer();
                List<Referee> referees = refereePersistentRemote.allArbitrator();
                List<Court> courts = courtPersistentRemote.allCourts();

                req.setAttribute(Constantes.NEW_MATCH_FORM_FIELD_PART_A, players);
                req.setAttribute(Constantes.NEW_MATCH_FORM_FIELD_PART_B, players);
                req.setAttribute(Constantes.NEW_MATCH_FORM_FIELD_REFEREE, referees);
                req.setAttribute(Constantes.NEW_MATCH_FORM_FIELD_COURT, courts);

                this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_SINGLE_MATCH).forward(req, resp);
            }
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            this.checkAuthentication(req);
            this.tryToSaveMatch(req);
            resp.sendRedirect("../" + Constantes.URL_HOME);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        } catch (InvalidMatchException e) {
            req.setAttribute("errorMessage",  e.getMessage());
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_SINGLE_MATCH).forward(req, resp);
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

    private void tryToSaveMatch(HttpServletRequest req) throws InvalidMatchException {
        // TODO
        // String startDate = this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_START_DATE);
        Date startDate = new Date();
        Tournament tournament = this.getTournament(req);
        Referee referee = this.getReferee(req);
        Court court = this.getCourt(req);
        Player playerA = this.getPlayer(req, Constantes.NEW_MATCH_FORM_FIELD_PART_A);
        Player playerB = this.getPlayer(req, Constantes.NEW_MATCH_FORM_FIELD_PART_B);

        List<Player> playersList = new ArrayList<>();
        playersList.add(playerA);
        playersList.add(playerB);

        this.validateNewMatch(startDate, tournament, referee, court, playerA, playerB);

        // TODO startDate / endDate
        SingleMatch newSingleMatch = new SingleMatch(startDate, startDate, 0, 0, tournament, court, referee, playersList);
        singleMatchRemote.saveSingleMatch(newSingleMatch);
    }

    private Player getPlayer(HttpServletRequest req, String field) {
        int courtId = Integer.parseInt(this.getValue(req, field));
        Player player = playerPersistentRemote.findPlayerById(courtId);
        return player;
    }

    private Court getCourt(HttpServletRequest req) {
        int courtId = Integer.parseInt(this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_COURT));
        Court court = courtPersistentRemote.findCourtById(courtId);
        return court;
    }

    private Referee getReferee(HttpServletRequest req) {
        int refereeId = Integer.parseInt(this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_REFEREE));
        Referee referee = refereePersistentRemote.getArbitratorById(refereeId);
        return referee;
    }

    private Tournament getTournament(HttpServletRequest req) {
        TypeTournament type = TypeTournament.valueOf(req.getParameter(Constantes.URL_PARAM_MATCH_TYPE));
        Gender gender = Gender.valueOf(req.getParameter(Constantes.URL_PARAM_GENDER));
        Tournament tournament = tournamentPersistentRemote.getTournamentByTypeAndGender(type, gender);
        return tournament;
    }

    private void validateNewMatch(Date startDate, Tournament tournament, Referee referee, Court court, Player playerA, Player playerB)
            throws InvalidMatchException {
        if (startDate == null || tournament == null || referee == null || court == null || playerA == null || playerB == null)
            throw new InvalidMatchException();
        if (playerA.getId() == playerB.getId())
            throw new InvalidMatchException("Les joueurs rentrés sont les mêmes");
    }

}
