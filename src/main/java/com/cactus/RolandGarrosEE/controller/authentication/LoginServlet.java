package com.cactus.RolandGarrosEE.controller.authentication;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.remotes.UserPeristentRemote;
import com.cactus.RolandGarrosEE.utils.PasswordUtils;
import com.cactus.RolandGarrosEE.utils.enums.UserRole;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidPasswordException;
import com.cactus.RolandGarrosEE.utils.exceptions.UserNotFoundException;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", value = "/connexion")
public class LoginServlet extends BaseServlet {

    @EJB
    UserPeristentRemote userPeristentRemote;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(Constantes.VIEW_LOGIN).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            //TODO Remove bypass
            User user = this.tryToLogUser(request);

            this.saveUserInfoIntoSession(request, user);
            response.sendRedirect(Constantes.URL_HOME);
        } catch (UserNotFoundException | InvalidPasswordException e) {
            request.setAttribute(Constantes.REQUEST_ATTR_CONNECTION_ERROR, e.getMessage());
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_LOGIN).forward(request, response);
        }

    }

    private User tryToLogUser(HttpServletRequest request) throws UserNotFoundException, InvalidPasswordException {
        String mail = this.getValue(request, Constantes.LOGIN_FORM_FIELD_MAIL);
        String password = this.getValue(request, Constantes.LOGIN_FORM_FIELD_PASSWORD);

        return this.getUserFromDatabase(mail, password);
    }

    private User getUserFromDatabase(String mail, String password) throws UserNotFoundException, InvalidPasswordException {
        boolean connectionOk = false;

        User user = userPeristentRemote.findUserByMail(mail);

        if (user == null)
            throw new UserNotFoundException();

        connectionOk = PasswordUtils.verifyPassword(user.getPassword(), password);

        if (!connectionOk)
            throw new InvalidPasswordException();

        return user;
    }

    private void saveUserInfoIntoSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(Constantes.SESSION_USER, user);
        session.setAttribute(Constantes.SESSION_IS_ADMIN, UserRole.ADMIN.equalsValue(user.getStatus()));
        session.setAttribute(Constantes.SESSION_IS_ORGANIZER, UserRole.ORGANIZER.equalsValue(user.getStatus()));
    }


}
