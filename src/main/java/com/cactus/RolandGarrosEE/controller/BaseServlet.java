package com.cactus.RolandGarrosEE.controller;

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

    protected void resetBreadcrumbs(){
        this.breadcrumbs.clear();
    }

    protected void propagateAttributesToRequest(HttpServletRequest request) {
        this.attributes.forEach(request::setAttribute);
        request.setAttribute(Constantes.REQUEST_ATTR_BREADCRUMBS, this.breadcrumbs);
    }

    protected void checkAuthentication(HttpServletRequest request) throws UnauthenticatedUserException {
        if(request.getSession().getAttribute(Constantes.SESSION_USER) == null)
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

}
