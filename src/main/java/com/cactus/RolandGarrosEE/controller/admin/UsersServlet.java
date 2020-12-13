package com.cactus.RolandGarrosEE.controller.admin;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.controller.Constantes;
import com.cactus.RolandGarrosEE.entities.Referee;
import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.remotes.UserPeristentRemote;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersServlet", value = "/utilisateurs")
public class UsersServlet extends BaseServlet {

    @EJB
    UserPeristentRemote userPeristentRemote;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            this.checkAuthentication(request);
            this.setupViewAttributes(request);
            this.getUsersList(request);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_USERS).forward(request, response);
        } catch (UnauthenticatedUserException e){
            response.sendRedirect(Constantes.URL_LOGIN);
        }
    }

    private void setupViewAttributes(HttpServletRequest request){
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_USERS);
        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_USERS);
        this.propagateAttributesToRequest(request);
    }

    private void getUsersList(HttpServletRequest request){
        List<User> usersList = userPeristentRemote.allUser();
        request.setAttribute(Constantes.REQUEST_ATTR_USERS_LIST,usersList);
    }
}

