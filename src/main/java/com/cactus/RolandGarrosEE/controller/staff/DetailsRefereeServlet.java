package com.cactus.RolandGarrosEE.controller.staff;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.Referee;
import com.cactus.RolandGarrosEE.repositories.remotes.RefereePersistentRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;
import com.cactus.RolandGarrosEE.utils.exceptions.UserNotFoundException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "detailsRefereeServlet", value = "/arbitre")
public class DetailsRefereeServlet extends BaseServlet {
    @EJB
    RefereePersistentRemote refereePersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);
            this.setRefereeInView(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_DETAILS_REFEREE).forward(req, resp);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect(Constantes.URL_LOGIN);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            this.checkAuthentication(req);

            String id = this.getValue(req, Constantes.REQUEST_ATTR_ID);
            Referee referee = refereePersistentRemote.findRefereeById(Integer.parseInt(id));

            if (req.getParameter(Constantes.NEW_DETAILS_UPDATE) != null)
            {
                this.tryToUpdateReferee(req, referee);
            } else if (req.getParameter(Constantes.NEW_DETAILS_DELETE) != null)
            {
                this.tryToDeleteReferee(req, referee);
            }

            resp.sendRedirect(Constantes.URL_REFEREES);
        } catch (UnauthenticatedUserException e) {
            e.printStackTrace();
        }
    }

    private void tryToDeleteReferee(HttpServletRequest req, Referee referee) {
        refereePersistentRemote.deleteReferee(referee);
    }

    private void tryToUpdateReferee(HttpServletRequest req, Referee referee) {
        referee.setFirstname(this.getValue(req, "firstname"));
        referee.setLastname(this.getValue(req, "lastname"));
        referee.setNationality(this.getValue(req, "actorNationality"));

        refereePersistentRemote.updateReferee(referee);
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_REFEREES);
        this.addToBreadcrumbs(Constantes.TITLE_REFEREE_DETAILS);
        this.attributes.put(Constantes.REQUEST_ATTR_ID, Constantes.TITLE_REFEREE_DETAILS);
        this.propagateAttributesToRequest(req);
    }

    private void setRefereeInView(HttpServletRequest req) throws UserNotFoundException {
        String id = this.getValue(req, Constantes.REQUEST_ATTR_ID);

        if (id == null)
            throw new UserNotFoundException();

        Referee referee = refereePersistentRemote.findRefereeById(Integer.parseInt(id));
        req.setAttribute(Constantes.NEW_DETAILS_REFEREE, referee);
    }
}
