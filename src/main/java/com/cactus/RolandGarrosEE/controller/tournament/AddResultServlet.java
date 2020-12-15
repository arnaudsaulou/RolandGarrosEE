package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.DoubleMatchPersistentRemote;
import com.cactus.RolandGarrosEE.repositories.remotes.SingleMatchRemote;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "addResultMatch", value = "/tournoi/ajouterResultat")
public class AddResultServlet extends BaseServlet {

    @EJB
    SingleMatchRemote singleMatchRemote;

    @EJB
    DoubleMatchPersistentRemote doubleMatchPersistentRemote;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.setupViewAttributes(req);

            // TODO Remove hardcore code double => Replace with enum (discuss which one)
            if (req.getParameter(Constantes.URL_PARAM_MATCH_TYPE).equals("double"))
            {
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_RESULT_DOUBLE_MATCH).forward(req, resp);
                req.setAttribute(Constantes.URL_PARAM_GENDER, req.getParameter(Constantes.URL_PARAM_GENDER));

            } else {
                this.getServletContext().getRequestDispatcher(Constantes.VIEW_RESULT_SINGLE_MATCH).forward(req, resp);
                req.setAttribute(Constantes.URL_PARAM_MATCH_TYPE, req.getParameter(Constantes.URL_PARAM_MATCH_TYPE));
            }
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            this.checkAuthentication(req);
            this.tryToPutResult(req, "1", "Single");
            resp.sendRedirect("../" + Constantes.URL_TEAM);
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

    private void tryToPutResult(HttpServletRequest req, String id, String type) {

        Match match;
        String dateEndMatch = req.getParameter(Constantes.NEW_MATCH_FORM_FIELD_END_DATE);
        String scoreA = req.getParameter(Constantes.NEW_MATCH_FORM_FIELD_SCORE_A);
        String scoreB = req.getParameter(Constantes.NEW_MATCH_FORM_FIELD_SCORE_B);

        if(type.equals("Single")){
            match = singleMatchRemote.findSingleMatchById(Integer.parseInt(id));
        } else {
            match = doubleMatchPersistentRemote.findDoubleMatchById(Integer.parseInt(id));
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            match.setDateEnd(formatter.parse(dateEndMatch));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        match.setScoreA(Integer.parseInt(scoreA));
        match.setScoreB(Integer.parseInt(scoreB));

        if(match instanceof SingleMatch){
            singleMatchRemote.updateScore(Integer.parseInt(id), scoreA, scoreB);
        } else {
            doubleMatchPersistentRemote.updateScore(Integer.parseInt(id), scoreA, scoreB);
        }
    }
}
