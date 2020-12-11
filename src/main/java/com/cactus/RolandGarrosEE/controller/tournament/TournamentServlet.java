package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.utils.enums.MatchGender;
import com.cactus.RolandGarrosEE.utils.enums.MatchType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "tournamentServlet", value = "/tournoi")
public class TournamentServlet extends BaseServlet {

    private static final String LOGIN_URL = "connexion";
    private static final String TITLE_BASE_SIMPLE = "Match Simple";
    private static final String TITLE_BASE_DOUBLE = "Match Double";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (this.isUserLogin(request))
            this.SelectMatchType(request, response);
        else
            response.sendRedirect(LOGIN_URL);
    }

    private boolean isUserLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userSession");
        return user != null;
    }

    private void SelectMatchType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchTypeString = request.getParameter("type");
        String genderString = request.getParameter("genre");

        try {
            MatchType matchType = MatchType.valueOf(matchTypeString);
            MatchGender matchGender = MatchGender.valueOf(genderString);

            this.resetBreadcrumbs();
            this.addToBreadcrumbs(matchType.toString());
            this.addToBreadcrumbs(matchGender.toString());

            switch (matchType) {
                case MatchSimple:
                    this.SimpleMatch(request, response, matchGender);
                    break;
                case MatchDouble:
                    this.DoubleMatch(request, response, matchGender);
                    break;
                default:
                    break;
            }

        } catch (IllegalArgumentException e) {
            this.NotFoundPage(request, response);
        }
    }

    private void NotFoundPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/pages/notFound.jsp").forward(request, response);
    }

    private void SimpleMatch(HttpServletRequest request, HttpServletResponse response, MatchGender matchGender) throws ServletException, IOException {
        this.attributes.put("title", TITLE_BASE_SIMPLE + " - " + matchGender.toString());
        this.propagateAttributesToRequest(request);
        this.getServletContext().getRequestDispatcher("/pages/grids/bodyGridSimple.jsp").forward(request, response);
    }

    private void DoubleMatch(HttpServletRequest request, HttpServletResponse response, MatchGender matchGender) throws ServletException, IOException {
        this.attributes.put("title", TITLE_BASE_DOUBLE + "-" + matchGender.toString());
        this.propagateAttributesToRequest(request);
        this.getServletContext().getRequestDispatcher("/pages/grids/bodyGridDouble.jsp").forward(request, response);
    }

}