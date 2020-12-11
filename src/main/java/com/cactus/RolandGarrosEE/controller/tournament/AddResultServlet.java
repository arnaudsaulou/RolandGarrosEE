package com.cactus.RolandGarrosEE.controller.tournament;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addResultMatch", value = "/tournoi/ajouterResultat")
public class AddResultServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("double"))
        {
            this.getServletContext().getRequestDispatcher("/pages/tournament/resultDoubleMatch.jsp").forward(req, resp);

        } else {
            this.getServletContext().getRequestDispatcher("/pages/tournament/resultSingleMatch.jsp").forward(req, resp);
        }
    }
}
