package org.example.shop.web.Controller;

import org.example.shop.dao.impl.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        logger.info("user \"{}\" 's password: {}", email, password);
        try {
            req.getRequestDispatcher("login.html").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
