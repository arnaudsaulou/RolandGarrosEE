package com.cactus.RolandGarrosEE.controller.authentication;

import com.cactus.RolandGarrosEE.entities.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", value = "/connexion")
public class LoginServlet extends HttpServlet {

    private static final String ATT_SESSION_USER = "userSession";
    private static final String VIEW_LOGIN = "/pages/login.jsp";
    private static final String HOME_URL = "Tournois?type=MatchSimple&genre=Femme";
    private static final String FIELD_MAIL = "mail";
    private static final String FIELD_PASSWORD = "password";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VIEW_LOGIN).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = this.tryToLogUser(request);
        this.saveUserIntoSession(request, user);
        response.sendRedirect(HOME_URL);
    }

    private User tryToLogUser(HttpServletRequest request) {

        String mail = this.getValue(request, FIELD_MAIL);
        String password = this.getValue(request, FIELD_PASSWORD);

        // TODO Get data from database (Wait UserEJB)
        User user = new User();
        user.setMail(mail);
        user.setPassword(password);

        return user;
    }

    private void saveUserIntoSession(HttpServletRequest request, User user){
        request.getSession().setAttribute(ATT_SESSION_USER, user);
    }

    private String getValue(HttpServletRequest request, String field) {
        String valeur = request.getParameter(field);
        if (valeur != null && valeur.isEmpty()) {
            return null;
        } else {
            return valeur;
        }
    }
}
