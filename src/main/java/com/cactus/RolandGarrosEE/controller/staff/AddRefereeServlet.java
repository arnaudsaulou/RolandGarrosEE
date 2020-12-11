package com.cactus.RolandGarrosEE.controller.staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ajouterArbitreServlet", value = "/arbitres/ajouterArbitre")
public class AddRefereeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/pages/actors/addReferee.jsp").forward(req, resp);
    }
}
