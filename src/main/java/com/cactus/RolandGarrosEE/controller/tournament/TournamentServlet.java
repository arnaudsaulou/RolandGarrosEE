package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.DoubleMatchPersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.SingleMatchRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.TournamentPersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "tournamentServlet", value = "/tournoi")
public class TournamentServlet extends BaseServlet {

    @EJB
    TournamentPersistentRemote tournamentPersistentRemote;

    @EJB
    SingleMatchRemote singleMatchRemote;

    @EJB
    DoubleMatchPersistentRemote doubleMatchPersistentRemote;

    private Tournament currentTournament;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.checkAuthentication(request);
            this.selectMatchType(request, response);
        } catch (UnauthenticatedUserException e) {
            response.sendRedirect(Constantes.URL_LOGIN);
        }
    }

    private void selectMatchType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            TypeTournament matchType = this.getTournamentTypeFromURL(request);
            Gender matchGender = this.getGenderFromURL(request);

            this.currentTournament = tournamentPersistentRemote.getTournamentByTypeAndGender(matchType, matchGender);

            // Pass attribute to setup the add button
            this.attributes.put(Constantes.URL_PARAM_MATCH_TYPE, matchType.toString());
            this.attributes.put(Constantes.URL_PARAM_GENDER, matchGender.toString());

            // Add breadcrumbs
            this.resetBreadcrumbs();
            this.addToBreadcrumbs(matchType.toString());
            this.addToBreadcrumbs(matchGender.toString());

            switch (matchType) {
                case SINGLE:
                    this.simpleMatch(request, response, matchGender);
                    break;
                case DOUBLE:
                    this.doubleMatch(request, response, matchGender);
                    break;
                default:
                    break;
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.notFoundPage(request, response, e.getMessage());
        }
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

    private void notFoundPage(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException {
        request.setAttribute(Constantes.REQUEST_ATTR__ERROR_MSG, errorMessage);
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_NOT_FOUND).forward(request, response);
    }

    private void simpleMatch(HttpServletRequest request, HttpServletResponse response, Gender matchGender) throws ServletException, IOException {
        List<SingleMatch> singleMatch = singleMatchRemote.allSingleMatchByTournamentId(currentTournament.getId());

        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_SINGLE_MATCH_BASE + " - " + matchGender.toString());
        this.attributes.put(Constantes.REQUEST_ATTR_SINGLE_MATCH_LIST, singleMatch);
        this.propagateAttributesToRequest(request);

        this.getServletContext().getRequestDispatcher(Constantes.VIEW_SINGLE_MATCH).forward(request, response);
    }

    private void doubleMatch(HttpServletRequest request, HttpServletResponse response, Gender matchGender) throws ServletException, IOException {
        List<DoubleMatch> doubleMatch = doubleMatchPersistentRemote.allDoubleMatchByTournamentId(currentTournament.getId());

        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_DOUBLE_MATCH_BASE + "-" + matchGender.toString());
        this.attributes.put(Constantes.REQUEST_ATTR_DOUBLE_MATCH_LIST, doubleMatch);
        this.propagateAttributesToRequest(request);

        this.getServletContext().getRequestDispatcher(Constantes.VIEW_DOUBLE_MATCH).forward(request, response);
    }

}