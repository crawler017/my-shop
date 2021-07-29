package org.example.shop.web.Controller;

import org.example.shop.dao.impl.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        logger.info("user \"{}\" 's password: {}", email, password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

    }
}
