package org.example.jetty;

import org.eclipse.jetty.http.HttpHeader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setHeader("Content-Type", "application/json");
        // HttpHeader에 setHeader에 필요한 name 값 포함하고 있음
        res.getWriter().write("Hello!");
    }
}
