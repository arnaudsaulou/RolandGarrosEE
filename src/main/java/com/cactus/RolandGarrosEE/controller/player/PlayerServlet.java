package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.controller.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "joueurServlet", value = "/joueurs")
public class PlayerServlet extends BaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.setupViewAttributes(req);
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_PLAYERS).forward(req, resp);
    }

    private void setupViewAttributes(HttpServletRequest req){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_PLAYERS);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_PLAYERS);
        this.propagateAttributesToRequest(req);
    }

}