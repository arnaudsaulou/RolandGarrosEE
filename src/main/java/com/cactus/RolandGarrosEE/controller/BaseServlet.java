package com.cactus.RolandGarrosEE.controller;

import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.PasswordUtils;
import com.cactus.RolandGarrosEE.utils.enums.UserRole;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseServlet extends HttpServlet {

    protected ArrayList<String> breadcrumbs = new ArrayList<>();
    protected HashMap<String, Object> attributes = new HashMap<>();

    protected void addToBreadcrumbs(String newBreadcrumbs) {
        breadcrumbs.add(newBreadcrumbs);
    }

    protected void resetBreadcrumbs() {
        this.breadcrumbs.clear();
    }

    protected void propagateAttributesToRequest(HttpServletRequest request) {
        this.attributes.forEach(request::setAttribute);
        request.setAttribute(Constantes.REQUEST_ATTR_BREADCRUMBS, this.breadcrumbs);
    }

    protected void checkAuthentication(HttpServletRequest request, UserRole role) throws UnauthenticatedUserException {
        User user = (User) request.getSession().getAttribute(Constantes.SESSION_USER);

        if (user == null)
            throw new UnauthenticatedUserException();

        ArrayList<String> tokens = new ArrayList<>();
        switch (role) {
            case ADMIN:
                tokens.add(PasswordUtils.generateToken(user.getMail(), UserRole.ADMIN));
                break;
            case ORGANIZER:
                tokens.add(PasswordUtils.generateToken(user.getMail(), UserRole.ADMIN));
                tokens.add(PasswordUtils.generateToken(user.getMail(), UserRole.ORGANIZER));
                break;
            case JOURNALIST:
                tokens.add(PasswordUtils.generateToken(user.getMail(), UserRole.ADMIN));
                tokens.add(PasswordUtils.generateToken(user.getMail(), UserRole.ORGANIZER));
                tokens.add(PasswordUtils.generateToken(user.getMail(), UserRole.JOURNALIST));
                break;
            default:
                throw new UnauthenticatedUserException();
        }

        if (!this.checkToken(tokens, user))
            throw new UnauthenticatedUserException();
    }

    protected String getValue(HttpServletRequest request, String field) {
        String valeur = request.getParameter(field);
        if (valeur != null && valeur.isEmpty()) {
            return null;
        } else {
            return valeur;
        }
    }

    private boolean checkToken(ArrayList<String> tokens, User user) {
        for (String token : tokens) {
            if (user.getToken().equals(token)) {
                return true;
            }
        }
        return false;
    }

}
