package com.cactus.RolandGarrosEE.controller.staff;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.controller.Constantes;
import com.cactus.RolandGarrosEE.entities.Referee;
import com.cactus.RolandGarrosEE.repositories.remotes.RefereePersistentRemote;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "arbitreServlet", value = "/arbitres")
public class RefereeServlet extends BaseServlet {

    @EJB
    RefereePersistentRemote refereePersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.getRefereesList(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_REFEREES).forward(req, resp);
        } catch (UnauthenticatedUserException e){
            resp.sendRedirect(Constantes.URL_LOGIN);
        }
    }

    private void setupViewAttributes(HttpServletRequest req){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_REFEREES);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_REFEREES);
        this.propagateAttributesToRequest(req);
    }

    private void getRefereesList(HttpServletRequest req){
        List<Referee> refereesList = refereePersistentRemote.allArbitrator();
        req.setAttribute(Constantes.REQUEST_ATTR_REFEREES_LIST,refereesList);
    }

}
