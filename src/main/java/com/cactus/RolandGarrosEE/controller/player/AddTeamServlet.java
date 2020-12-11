package com.cactus.RolandGarrosEE.controller.player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addEquipeServlet", value = "/equipes/ajouterEquipe")
public class AddTeamServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/pages/actors/addTeam.jsp").forward(req, resp);
    }
}
