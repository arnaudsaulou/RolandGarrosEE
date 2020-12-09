package com.cactus.RolandGarrosEE.controller;

import com.cactus.RolandGarrosEE.entities.User;
import com.cactus.RolandGarrosEE.repositories.UserPeristentRemote;

import java.io.*;
import javax.ejb.EJB;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @EJB
    UserPeristentRemote userPeristentRemote;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        User user = new User();
        user.setFirstName("Jean");
        user.setLastname("Didier");
        userPeristentRemote.AddUser(user);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + user.getFirstName() + " " + user.getLastname() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}