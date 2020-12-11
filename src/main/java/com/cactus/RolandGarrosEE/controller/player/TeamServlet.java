package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.controller.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "equipeServlet", value = "/equipes")
public class TeamServlet extends BaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.setupViewAttributes(req);
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_TEAMS).forward(req, resp);
    }

    private void setupViewAttributes(HttpServletRequest req){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_TEAMS);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_TEAMS);
        this.propagateAttributesToRequest(req);
    }
}
