package com.cactus.RolandGarrosEE.controller;

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

    protected void propagateAttributesToRequest(HttpServletRequest request) {
        this.attributes.forEach(request::setAttribute);
        request.setAttribute("breadcrumbs", this.breadcrumbs);
    }

    protected void resetBreadcrumbs(){
        this.breadcrumbs.clear();
    }

}
