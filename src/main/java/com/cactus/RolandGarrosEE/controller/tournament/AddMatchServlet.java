package com.cactus.RolandGarrosEE.controller.tournament;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ajouterMatch", value = "/tournoi/ajouterMatch")
public class AddMatchServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("double"))
        {
            this.getServletContext().getRequestDispatcher("/pages/tournament/addDoubleMatch.jsp").forward(req, resp);

        } else {
            this.getServletContext().getRequestDispatcher("/pages/tournament/addSingleMatch.jsp").forward(req, resp);
        }
    }
}
