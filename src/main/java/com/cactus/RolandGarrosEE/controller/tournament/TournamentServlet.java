package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.utils.MatchGender;
import com.cactus.RolandGarrosEE.utils.MatchType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "tournamentServlet", value = "/Tournois")
public class TournamentServlet extends HttpServlet {

    private static final String TITLE_BASE_SIMPLE = "Match Simple";
    private static final String TITLE_BASE_DOUBLE = "Match Double";
    private String[] breadcrumbs = new String[2];

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.SelectMatchType(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private void UpdateBreadcrumb(MatchType matchType, MatchGender matchGender) {
        breadcrumbs[0] = matchType.toString();
        breadcrumbs[1] = matchGender.toString();
    }

    private void SelectMatchType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchTypeString = request.getParameter("type");
        String genderString = request.getParameter("genre");

        try {
            MatchType matchType = MatchType.valueOf(matchTypeString);
            MatchGender matchGender = MatchGender.valueOf(genderString);

            this.UpdateBreadcrumb(matchType, matchGender);

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

    private void setAttribute(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        request.setAttribute("breadcrumbs", breadcrumbs);

        /* TODO */
        request.setAttribute("isConnected", true);
        request.setAttribute("isOrganizer", false);
    }

    private void NotFoundPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/notFound.jsp").forward(request, response);
    }

    private void SimpleMatch(HttpServletRequest request, HttpServletResponse response, MatchGender matchGender) throws ServletException, IOException {
        this.setAttribute(request, TITLE_BASE_SIMPLE + " - " + matchGender.toString());
        this.getServletContext().getRequestDispatcher("/pages/bodyGridSimple.jsp").forward(request, response);
    }

    private void DoubleMatch(HttpServletRequest request, HttpServletResponse response, MatchGender matchGender) throws ServletException, IOException {
        this.setAttribute(request, TITLE_BASE_DOUBLE + " - " + matchGender.toString());

        // TODO Remove
        this.getServletContext().getRequestDispatcher("/WEB-INF/header.jsp").forward(request, response);

        // TODO Add
        //this.getServletContext().getRequestDispatcher("/WEB-INF/bodyGridDouble.jsp").forward(request, response);
    }

}
