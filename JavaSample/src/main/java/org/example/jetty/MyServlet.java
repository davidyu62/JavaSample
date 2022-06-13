package org.example.jetty;

import org.eclipse.jetty.http.HttpHeader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setHeader("Content-Type", "application/json");
        // HttpHeader에 setHeader에 필요한 name 값 포함하고 있음
        res.getWriter().write("Hello!");
    }

    // allow the both request get and post.
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        /* Read Header */
        Enumeration headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = (String)headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + " : " + value + "<br>");
        }

        res.setStatus(200);
        res.setHeader("Content-Type", "application/json");
        // HttpHeader에 setHeader에 필요한 name 값 포함하고 있음
        res.getWriter().write("Hello! service");
    }
}
