package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.Gender;
import com.cactus.RolandGarrosEE.entities.TypeTournament;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "tournamentServlet", value = "/tournoi")
public class TournamentServlet extends BaseServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.checkAuthentication(request);
            this.selectMatchType(request, response);
        } catch (UnauthenticatedUserException e) {
            response.sendRedirect(Constantes.URL_LOGIN);
        }
    }

    private void selectMatchType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchTypeString = request.getParameter(Constantes.URL_PARAM_MATCH_TYPE);
        String genderString = request.getParameter(Constantes.URL_PARAM_GENDER);

        try {
            TypeTournament matchType = TypeTournament.valueOf(matchTypeString);
            Gender matchGender = Gender.valueOf(genderString);

            request.setAttribute(Constantes.URL_PARAM_MATCH_TYPE, matchType);
            request.setAttribute(Constantes.URL_PARAM_GENDER, matchGender);

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
            this.notFoundPage(request, response);
        }
    }

    private void notFoundPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_NOT_FOUND).forward(request, response);
    }

    private void simpleMatch(HttpServletRequest request, HttpServletResponse response, Gender matchGender) throws ServletException, IOException {
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_SINGLE_MATCH_BASE + " - " + matchGender.toString());
        this.propagateAttributesToRequest(request);
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_SINGLE_MATCH).forward(request, response);
    }

    private void doubleMatch(HttpServletRequest request, HttpServletResponse response, Gender matchGender) throws ServletException, IOException {
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_DOUBLE_MATCH_BASE + "-" + matchGender.toString());
        this.propagateAttributesToRequest(request);
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_DOUBLE_MATCH).forward(request, response);
    }

}