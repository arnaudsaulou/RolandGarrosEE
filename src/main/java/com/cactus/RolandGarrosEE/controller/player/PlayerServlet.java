package com.cactus.RolandGarrosEE.controller.player;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "joueurServlet", value = "/joueurs")
public class PlayerServlet extends BaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_PLAYERS).forward(req, resp);
        } catch (UnauthenticatedUserException e){
            resp.sendRedirect(Constantes.URL_LOGIN);
        }
    }

    private void setupViewAttributes(HttpServletRequest req){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_PLAYERS);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_PLAYERS);
        this.propagateAttributesToRequest(req);
    }

}