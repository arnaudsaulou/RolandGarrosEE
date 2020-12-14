package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addResultMatch", value = "/tournoi/ajouterResultat")
public class AddResultServlet extends BaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);

            // TODO Remove hardcore code double => Replace with enum (discuss which one)
            if (req.getParameter(Constantes.URL_PARAM_MATCH_TYPE).equals("double"))
            {
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_RESULT_DOUBLE_MATCH).forward(req, resp);

            } else {
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_RESULT_SINGLE_MATCH).forward(req, resp);
            }
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();

        //TODO Choose breadcrumbs to display
        /*this.addToBreadcrumbs();
        this.addToBreadcrumbs();*/
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_RESULT);
        this.propagateAttributesToRequest(req);
    }
}
