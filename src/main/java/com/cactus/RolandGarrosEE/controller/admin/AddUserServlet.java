package com.cactus.RolandGarrosEE.controller.admin;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.remotes.UserPeristentRemote;
import com.cactus.RolandGarrosEE.utils.PasswordUtils;
import com.cactus.RolandGarrosEE.utils.enums.UserRole;
import com.cactus.RolandGarrosEE.utils.exceptions.*;

import java.io.IOException;
import java.util.Optional;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addUserServlet", value = "/utilisateurs/ajouterUtilisateur")
public class AddUserServlet extends BaseServlet {

    @EJB
    UserPeristentRemote userPeristentRemote;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            this.checkAuthentication(request);
            this.setupViewAttributes(request);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_USER).forward(request, response);
        } catch (UnauthenticatedUserException e) {
            response.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            this.checkAuthentication(request);
            this.tryToSaveUser(request);
            response.sendRedirect("../" + Constantes.URL_USERS);
        } catch (UnauthenticatedUserException e) {
            response.sendRedirect("../" + Constantes.URL_LOGIN);
        } catch (InvalidActorException e) {
            request.setAttribute("errorMessage", e.getMessage());
            //response.sendRedirect(Constantes.URL_ADD_USER);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_USER).forward(request, response);
        }
    }

    private void setupViewAttributes(HttpServletRequest request) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_USERS);
        this.addToBreadcrumbs(Constantes.TITLE_ADD_USER);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_USER);
        this.propagateAttributesToRequest(request);
    }

    private void tryToSaveUser(HttpServletRequest req) throws InvalidActorException{
        String firstname = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_FIRSTNAME);
        String lastname = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_LASTNAME);
        String mail = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_MAIL);
        String password = this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_PASSWORD);
        int status = Integer.parseInt(this.getValue(req, Constantes.NEW_ACTOR_FORM_FIELD_STATUS));
        this.validateNewUser(firstname, lastname, mail, password, status);
        if (userPeristentRemote.allMails().contains(mail)){
            throw new InvalidActorException("Ce mail est déjà utilisé");
        }
        Optional<String> hashedPassword = PasswordUtils.hashPassword(password);
        if (hashedPassword.isPresent()) {
            User newUser = new User(firstname, lastname, mail, hashedPassword.get(), status);
            userPeristentRemote.saveUser(newUser);
        } else {
            throw new InvalidActorException();
        }
    }

    private void validateNewUser(String firstname, String lastname, String mail, String password, int status) throws InvalidActorException {
        try {
            UserRole.checkUserRole(status);
            if (firstname == null || lastname == null || mail == null || password == null)
                throw new InvalidActorException();
        } catch (InvalidUserRoleException e) {
            throw new InvalidActorException();
        }
    }

}

