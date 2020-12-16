package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.DoubleMatchPersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.SingleMatchRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidActorException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "addResultMatch", value = "/tournoi/ajouterResultat")
public class AddResultServlet extends BaseServlet {

    @EJB
    SingleMatchRemote singleMatchRemote;

    @EJB
    DoubleMatchPersistentRemote doubleMatchPersistentRemote;

    private TypeTournament typeTournament;
    private Gender gender;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);

            this.typeTournament = this.getTournamentTypeFromURL(req);
            this.gender = this.getGenderFromURL(req);
            int idMatch = this.getMatchId(req);

            this.attributes.put(Constantes.URL_PARAM_MATCH_TYPE, this.typeTournament.toString());
            this.attributes.put(Constantes.URL_PARAM_GENDER, this.gender.toString());
            this.attributes.put(Constantes.URL_PARAM_MATCH_ID, idMatch);

            this.propagateAttributesToRequest(req);

            if (typeTournament.equals(TypeTournament.SINGLE)) {
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_RESULT_SINGLE_MATCH).forward(req, resp);
            } else {
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_RESULT_DOUBLE_MATCH).forward(req, resp);
            }

        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);

            Match match = getMatch(req);

            if (req.getParameter(Constantes.NEW_MATCH_ADD) != null) {
                this.tryToPutResult(req, match);
            } else if (req.getParameter(Constantes.NEW_DETAILS_DELETE) != null) {
                this.tryToDeleteMatch(req, match);
            }

            resp.sendRedirect("../" + Constantes.URL_TOURNAMENT + "?" + Constantes.URL_PARAM_MATCH_TYPE + "=" + this.typeTournament + "&" + Constantes.URL_PARAM_GENDER + "=" + this.gender);
        } catch (UnauthenticatedUserException | InvalidActorException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_SINGLE_MATCH_BASE);
        this.addToBreadcrumbs(Constantes.TITLE_ADD_RESULT);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_RESULT);
        this.propagateAttributesToRequest(req);
    }

    private Gender getGenderFromURL(HttpServletRequest request) throws IllegalArgumentException {
        String genderString = this.getValue(request, Constantes.URL_PARAM_GENDER);
        if (genderString == null)
            throw new IllegalArgumentException("Genre non renseigné");
        return Gender.getGenderFromString(genderString);
    }

    private TypeTournament getTournamentTypeFromURL(HttpServletRequest request) throws IllegalArgumentException {
        String matchTypeString = this.getValue(request, Constantes.URL_PARAM_MATCH_TYPE);
        if (matchTypeString == null)
            throw new IllegalArgumentException("Type de tournois non renseigné");
        return TypeTournament.getTypeTournamentFromString(matchTypeString);
    }

    private Match getMatch(HttpServletRequest req){
        int matchId = this.getMatchId(req);

        TypeTournament tournamentType = this.getTournamentType(req);

        Match match;

        if (tournamentType.equals(TypeTournament.SINGLE)) {
            match = singleMatchRemote.findSingleMatchById(matchId);
        } else {
            match = doubleMatchPersistentRemote.findDoubleMatchById(matchId);
        }

        return match;
    }

    private void tryToPutResult(HttpServletRequest req, Match match) {
        String dateEndMatch = req.getParameter(Constantes.NEW_MATCH_FORM_FIELD_END_DATE);
        String scoreA = req.getParameter(Constantes.NEW_MATCH_FORM_FIELD_SCORE_A);
        String scoreB = req.getParameter(Constantes.NEW_MATCH_FORM_FIELD_SCORE_B);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = formatter.parse(dateEndMatch.replace("T", " "));
            match.setDateEnd(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        match.setScoreA(Integer.parseInt(scoreA));
        match.setScoreB(Integer.parseInt(scoreB));

        if (match instanceof SingleMatch) {
            singleMatchRemote.updateScore(match.getId(), scoreA, scoreB, match.getDateEnd());
        } else {
            doubleMatchPersistentRemote.updateScore(match.getId(), scoreA, scoreB, match.getDateEnd());
        }
    }

    private void tryToDeleteMatch(HttpServletRequest req, Match match) throws InvalidActorException {
        if (match instanceof SingleMatch) {
            singleMatchRemote.deleteSingleMatch((SingleMatch) match);
        } else {
            doubleMatchPersistentRemote.deleteDoubleMatch((DoubleMatch) match);
        }
    }

    private TypeTournament getTournamentType(HttpServletRequest req) {
        String typeTournamentString = this.getValue(req, Constantes.URL_PARAM_MATCH_TYPE);
        if (typeTournamentString == null)
            throw new IllegalArgumentException("Type de tournoi non définie");
        return TypeTournament.getTypeTournamentFromString(typeTournamentString);
    }

    private int getMatchId(HttpServletRequest req) {
        String idMatchString = this.getValue(req, Constantes.URL_PARAM_MATCH_ID);
        if(idMatchString == null)
            throw new IllegalArgumentException("Numéro de match non renseignée");
        return Integer.parseInt(idMatchString);
    }
}
