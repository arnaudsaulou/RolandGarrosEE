package com.cactus.RolandGarrosEE.controller.authentication;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.controller.Constantes;
import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.utils.exceptions.UserNotFoundException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", value = "/connexion")
public class LoginServlet extends BaseServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_LOGIN).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = this.tryToLogUser(request);
            this.saveUserInfoIntoSession(request, user);
            response.sendRedirect(Constantes.URL_HOME);
        } catch (UserNotFoundException e) {
            request.setAttribute(Constantes.REQUEST_ATTR_CONNECTION_ERROR, e.getMessage());
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_LOGIN).forward(request, response);
        }

    }

    private User tryToLogUser(HttpServletRequest request) throws UserNotFoundException {
        String mail = this.getValue(request, Constantes.LOGIN_FORM_FIELD_MAIL);
        String password = this.getValue(request, Constantes.LOGIN_FORM_FIELD_PASSWORD);
        return this.getUserFromDatabase(mail, password);
    }

    private User getUserFromDatabase(String mail, String password) throws UserNotFoundException {

        // TODO Get data from database (Wait UserEJB)

        if(mail.equals("error@test.com"))
            throw new UserNotFoundException();

        User user = new User();
        user.setMail(mail);
        user.setPassword(password);
        user.setFirstname("Patrick");
        user.setLastname("Teller");
        user.setStatus(0);

        return user;
    }

    private void saveUserInfoIntoSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(Constantes.SESSION_USER, user);
        session.setAttribute(Constantes.SESSION_IS_ORGANIZER, user.getStatus() == 0);
    }


}
