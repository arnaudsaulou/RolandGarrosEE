package com.cactus.RolandGarrosEE.controller.player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ajouterJoueurServlet", value = "/joueurs/ajouterJoueur")
public class AddPlayerServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/pages/actors/addPlayer.jsp").forward(req, resp);
    }
}
