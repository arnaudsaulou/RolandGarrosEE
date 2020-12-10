package com.cactus.RolandGarrosEE.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "bodyGridSimpleServlet", value = "/MatchSimple")
public class SimpleMatchServlet extends HttpServlet {

    private static final String TITLE_BASE = "Match Simple";
    private List<String> ancestor_breadcrumb = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String type = request.getParameter("type");
        ancestor_breadcrumb.clear();
        ancestor_breadcrumb.add(TITLE_BASE);
        ancestor_breadcrumb.add(type);

        request.setAttribute("title", TITLE_BASE + " - "+ type);
        request.setAttribute("ancestor_breadcrumb", ancestor_breadcrumb);

        // TODO Remove
        this.getServletContext().getRequestDispatcher("/WEB-INF/Header.jsp").forward(request, response);

        // TODO Add
        //this.getServletContext().getRequestDispatcher("/WEB-INF/BodyGridSimple.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
