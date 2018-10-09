package com.epam.lab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    private String name;
    private String title;
    private static int iter = 0;


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.handleRequest(req, resp, "Delete ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("ajax") != null) {
            this.handleRequest(req, resp, "Get ");
        }
        else
          req.getRequestDispatcher("WEB-INF/jsp/greet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.handleRequest(req, resp, "Post ");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.handleRequest(req, resp, "Put ");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Good Bye");
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp, String text) throws IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(text + processingCookies(req, resp));
    }

    private String processingCookies(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        Cookie answer = null;
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("count")){
                answer = cookie;
                break;
            }
        }
        if (answer != null){
            int text = Integer.parseInt(answer.getValue());
            text++;
            answer = new Cookie("count", "" + text);
            resp.addCookie(answer);
            return Integer.toString(text);
        }
        answer = new Cookie("count", "1");
        resp.addCookie(answer);
        return "1";
    }
}
